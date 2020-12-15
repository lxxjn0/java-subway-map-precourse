package subway.line.application;

import java.util.Arrays;
import java.util.List;

import subway.line.domain.LineRepository;
import subway.line.exception.IllegalLineException;
import subway.section.domain.Section;
import subway.section.domain.SectionRepository;
import subway.station.domain.StationRepository;
import subway.station.exception.IllegalStationException;

public class LineService {
    public static final int UP_LAST_SECTION_INIT_SEQUENCE = 1;
    public static final int DOWN_LAST_SECTION_INIT_SEQUENCE = 2;
    private final LineRepository lineRepository;
    private final StationRepository stationRepository;
    private final SectionRepository sectionRepository;

    public LineService(
            final StationRepository stationRepository,
            final LineRepository lineRepository,
            final SectionRepository sectionRepository
    ) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
        this.sectionRepository = sectionRepository;
    }

    public void create(final LineRequest request) {
        if (lineRepository.existsByName(request.getLineName())) {
            throw new IllegalLineException(IllegalLineException.ALREADY_EXISTS);
        }

        if (!stationRepository.existsByName(request.getUpLastStationName())) {
            throw new IllegalStationException(IllegalStationException.NOT_EXISTS);
        }

        if (!stationRepository.existsByName(request.getDownLastStationName())) {
            throw new IllegalStationException(IllegalStationException.NOT_EXISTS);
        }

        lineRepository.save(request.toEntity());
        sectionRepository.saveAll(connectSections(request));
    }

    private List<Section> connectSections(final LineRequest request) {
        final Section upLastSection = Section.of(request.getLineName(),
                request.getUpLastStationName(), UP_LAST_SECTION_INIT_SEQUENCE);
        final Section downLastSection = Section.of(request.getLineName(),
                request.getUpLastStationName(), DOWN_LAST_SECTION_INIT_SEQUENCE);

        return Arrays.asList(upLastSection, downLastSection);
    }

    public List<LineResponse> showAll() {
        return LineResponse.toList(lineRepository.findAll());
    }

    public LineDeleteResponse deleteByName(final LineDeleteRequest request) {
        if (!lineRepository.existsByName(request.getName())) {
            throw new IllegalLineException(IllegalLineException.NOT_EXISTS);
        }

        sectionRepository.deleteAllByLine(request.toEntity());
        return new LineDeleteResponse(lineRepository.deleteByName(request.getName()));
    }
}

package subway.line.application;

import java.util.List;

import subway.line.domain.LineRepository;
import subway.line.exception.IllegalLineException;
import subway.section.domain.SectionRepository;
import subway.station.domain.StationRepository;
import subway.station.exception.IllegalStationException;

public class LineService {
    private final LineRepository lineRepository;
    private final StationRepository stationRepository;
    private final SectionRepository sectionRepository;

    public LineService(
            final LineRepository lineRepository,
            final StationRepository stationRepository,
            final SectionRepository sectionRepository
    ) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
        this.sectionRepository = sectionRepository;
    }

    public void create(final LineRequest request) {
        if (!stationRepository.existsByName(request.getUpLastStationName())) {
            throw new IllegalStationException(IllegalStationException.NOT_EXISTS);
        }

        if (!stationRepository.existsByName(request.getDownLastStationName())) {
            throw new IllegalStationException(IllegalStationException.NOT_EXISTS);
        }

        if (lineRepository.existsByName(request.getLineName())) {
            throw new IllegalLineException(IllegalLineException.ALREADY_EXISTS);
        }

        lineRepository.save(request.toEntity());
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

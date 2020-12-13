package subway.line.application;

import subway.line.domain.LineRepository;
import subway.line.exception.IllegalLineException;
import subway.section.application.SectionService;
import subway.station.domain.StationRepository;
import subway.station.exception.IllegalStationException;

public class LineService {
    private final LineRepository lineRepository;
    private final StationRepository stationRepository;
    private final SectionService sectionService;

    public LineService(
            final LineRepository lineRepository,
            final StationRepository stationRepository,
            final SectionService sectionService
    ) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
        this.sectionService = sectionService;
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
}
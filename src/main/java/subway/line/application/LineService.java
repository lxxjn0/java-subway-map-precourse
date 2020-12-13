package subway.line.application;

import static subway.station.exception.IllegalStationException.*;

import subway.line.domain.LineRepository;
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
            throw new IllegalStationException(NOT_EXISTS);
        }
        lineRepository.save(request.toEntity());
    }
}

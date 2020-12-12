package subway.section.application;

import static subway.station.exception.IllegalStationException.*;

import subway.line.domain.LineRepository;
import subway.section.domain.SectionRepository;
import subway.station.domain.StationRepository;
import subway.station.exception.IllegalStationException;

public class SectionService {
    private final StationRepository stationRepository;
    private final LineRepository lineRepository;
    private final SectionRepository sectionRepository;

    public SectionService(final StationRepository stationRepository,
            final LineRepository lineRepository, final SectionRepository sectionRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
        this.sectionRepository = sectionRepository;
    }

    public void create(final SectionRequest request) {
        if (!stationRepository.existsByName(request.getStationName())) {
            throw new IllegalStationException(NOT_EXISTS);
        }
        sectionRepository.save(request.toEntity());
    }
}

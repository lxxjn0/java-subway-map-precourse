package subway.station.application;

import static subway.station.exception.IllegalStationException.*;

import subway.section.domain.SectionRepository;
import subway.station.domain.StationRepository;
import subway.station.exception.IllegalStationException;

public class StationDeleteService {
    private final StationRepository stationRepository;
    private final SectionRepository sectionRepository;

    public StationDeleteService(final StationRepository stationRepository,
            final SectionRepository sectionRepository) {
        this.stationRepository = stationRepository;
        this.sectionRepository = sectionRepository;
    }

    public boolean removeByName(final StationDeleteRequest request) {
        if (!stationRepository.existsByName(request.getName())) {
            throw new IllegalStationException(NOT_EXISTS);
        }

        if (sectionRepository.existsByStation(request.toEntity())) {
            throw new IllegalStationException(REGISTERED_SECTION);
        }

        return stationRepository.deleteByName(request.getName());
    }
}

package subway.station.application;

import static subway.station.exception.IllegalStationException.*;

import subway.station.domain.StationRepository;
import subway.station.exception.IllegalStationException;

public class StationDeleteService {
    private final StationRepository stationRepository;

    public StationDeleteService(final StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public boolean removeByName(final StationDeleteRequest request) {
        if (!stationRepository.existsByName(request.getName())) {
            throw new IllegalStationException(NOT_EXISTS);
        }
        return stationRepository.deleteByName(request.getName());
    }
}

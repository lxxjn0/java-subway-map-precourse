package subway.station.application;

import static subway.station.exception.IllegalStationException.*;

import java.util.List;

import subway.station.domain.StationRepository;
import subway.station.exception.IllegalStationException;

public class StationService {
    private final StationRepository stationRepository;

    public StationService(final StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void create(final StationRequest request) {
        if (stationRepository.existsByName(request.getName())) {
            throw new IllegalStationException(ALREADY_EXISTS);
        }
        stationRepository.save(request.toEntity());
    }

    public List<StationResponse> showAll() {
        return StationResponse.toList(stationRepository.findAll());
    }
}

package subway.station.application;

import static subway.station.exception.IllegalStationException.*;

import java.util.List;

import subway.station.domain.Station;
import subway.station.domain.StationRepository;
import subway.station.exception.IllegalStationException;

public class StationService {
    private final StationRepository stationRepository;

    public StationService(final StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void create(final Station station) {
        if (stationRepository.existsByName(station.getName())) {
            throw new IllegalStationException(ALREADY_EXISTS);
        }
        stationRepository.save(station);
    }

    public List<Station> show() {
        return stationRepository.findAll();
    }
}

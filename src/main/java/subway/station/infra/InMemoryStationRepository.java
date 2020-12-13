package subway.station.infra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import subway.station.domain.Station;
import subway.station.domain.StationRepository;

public class InMemoryStationRepository implements StationRepository {
    private static final List<Station> STATIONS = new ArrayList<>();

    @Override
    public List<Station> findAll() {
        return Collections.unmodifiableList(STATIONS);
    }

    @Override
    public boolean existsByName(final String name) {
        return STATIONS.stream()
                .anyMatch(station -> station.match(name))
                ;
    }

    @Override
    public void save(final Station station) {
        STATIONS.add(station);
    }

    @Override
    public void saveAll(final Collection<Station> stations) {
        STATIONS.addAll(stations);
    }

    @Override
    public boolean deleteByName(final String name) {
        return STATIONS.removeIf(station -> station.match(name));
    }
}

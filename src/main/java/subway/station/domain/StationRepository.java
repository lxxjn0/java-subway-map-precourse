package subway.station.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StationRepository {
    private static final List<Station> STATIONS = new ArrayList<>();

    public List<Station> findAll() {
        return Collections.unmodifiableList(STATIONS);
    }

    public boolean existsByName(final String name) {
        return STATIONS.stream()
                .anyMatch(station -> station.match(name))
                ;
    }

    public void save(final Station station) {
        STATIONS.add(station);
    }

    public void saveAll(final Collection<Station> stations) {
        STATIONS.addAll(stations);
    }

    public boolean deleteByName(final String name) {
        return STATIONS.removeIf(station -> station.match(name));
    }
}

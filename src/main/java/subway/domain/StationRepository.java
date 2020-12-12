package subway.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> STATIONS = new ArrayList<>();

    public List<Station> findAll() {
        return Collections.unmodifiableList(STATIONS);
    }

    public void save(final Station station) {
        STATIONS.add(station);
    }

    public void saveAll(final Collection<Station> stations) {
        STATIONS.addAll(stations);
    }

    public boolean deleteByName(final String name) {
        return STATIONS.removeIf(station -> Objects.equals(station.getName(), name));
    }
}

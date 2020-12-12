package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }

    public void save(Station station) {
        stations.add(station);
    }

    public boolean deleteByName(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}

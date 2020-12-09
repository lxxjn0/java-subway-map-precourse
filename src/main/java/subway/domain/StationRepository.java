package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository implements Repository<Station, String> {
    private static final List<Station> stations = new ArrayList<>();

    @Override
    public List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }

    @Override
    public void save(Station station) {
        stations.add(station);
    }

    @Override
    public boolean delete(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}

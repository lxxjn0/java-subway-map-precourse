package subway.station.domain;

import java.util.Collection;
import java.util.List;

public interface StationRepository {
    List<Station> findAll();

    boolean existsByName(final String name);

    void save(final Station station);

    void saveAll(final Collection<Station> stations);

    boolean deleteByName(final String name);
}

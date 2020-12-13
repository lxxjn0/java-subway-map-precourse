package subway.line.domain;

import java.util.Collection;
import java.util.List;

public interface LineRepository {
    List<Line> findAll();

    boolean existsByName(final String name);

    boolean existsAllByNameIn(final Collection<String> names);

    void save(final Line line);

    void saveAll(final Collection<Line> lines);

    boolean deleteByName(final String name);
}

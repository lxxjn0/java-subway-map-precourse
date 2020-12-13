package subway.line.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final List<Line> LINES = new ArrayList<>();

    public List<Line> findAll() {
        return Collections.unmodifiableList(LINES);
    }

    public boolean existsByName(final String name) {
        return LINES.stream()
                .anyMatch(line -> line.match(name))
                ;
    }

    public boolean existsAllByNameIn(final Collection<String> names) {
        return names.stream()
                .allMatch(this::existsByName)
                ;
    }

    public void save(final Line line) {
        LINES.add(line);
    }

    public void saveAll(final Collection<Line> lines) {
        LINES.addAll(lines);
    }

    public boolean deleteByName(final String name) {
        return LINES.removeIf(line -> line.match(name));
    }
}

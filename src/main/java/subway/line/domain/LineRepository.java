package subway.line.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> LINES = new ArrayList<>();

    public List<Line> findAll() {
        return Collections.unmodifiableList(LINES);
    }

    public void save(final Line line) {
        LINES.add(line);
    }

    public void saveAll(final Collection<Line> lines) {
        LINES.addAll(lines);
    }

    public boolean deleteByName(final String name) {
        return LINES.removeIf(line -> Objects.equals(line.getName(), name));
    }
}

package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public List<Line> findAll() {
        return Collections.unmodifiableList(lines);
    }

    public void save(Line line) {
        lines.add(line);
    }

    public boolean deleteByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}

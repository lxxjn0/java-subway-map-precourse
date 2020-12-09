package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository implements Repository<Line, String> {
    private static final List<Line> lines = new ArrayList<>();

    @Override
    public List<Line> findAll() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public void save(Line line) {
        lines.add(line);
    }

    @Override
    public boolean delete(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}

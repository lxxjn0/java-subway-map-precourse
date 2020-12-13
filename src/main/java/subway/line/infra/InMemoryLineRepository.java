package subway.line.infra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import subway.line.domain.Line;
import subway.line.domain.LineRepository;

public class InMemoryLineRepository implements LineRepository {
    private static final List<Line> LINES = new ArrayList<>();

    @Override
    public List<Line> findAll() {
        return Collections.unmodifiableList(LINES);
    }

    @Override
    public boolean existsByName(final String name) {
        return LINES.stream()
                .anyMatch(line -> line.match(name))
                ;
    }

    @Override
    public boolean existsAllByNameIn(final Collection<String> names) {
        return names.stream()
                .allMatch(this::existsByName)
                ;
    }

    @Override
    public void save(final Line line) {
        LINES.add(line);
    }

    @Override
    public void saveAll(final Collection<Line> lines) {
        LINES.addAll(lines);
    }

    @Override
    public boolean deleteByName(final String name) {
        return LINES.removeIf(line -> line.match(name));
    }
}

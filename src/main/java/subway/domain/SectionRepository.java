package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public List<Section> findAll() {
        return Collections.unmodifiableList(sections);
    }

    public void save(final Section section) {
        sections.add(section);
    }

    public boolean deleteByLineAndStation(final Line line, final Station station) {
        return sections.removeIf(
                section -> Objects.equals(section.getLine(), line)
                        && Objects.equals(section.getStation(), station));
    }
}

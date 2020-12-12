package subway.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SectionRepository {
    private static final List<Section> SECTIONS = new ArrayList<>();

    public List<Section> findAll() {
        return Collections.unmodifiableList(SECTIONS);
    }

    public void save(final Section section) {
        SECTIONS.add(section);
    }

    public void saveAll(final Collection<Section> sections) {
        SECTIONS.addAll(sections);
    }

    public boolean deleteByLineAndStation(final Line line, final Station station) {
        return SECTIONS.removeIf(
                section -> Objects.equals(section.getLine(), line)
                        && Objects.equals(section.getStation(), station));
    }
}

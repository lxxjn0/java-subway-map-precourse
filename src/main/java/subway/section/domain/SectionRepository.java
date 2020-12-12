package subway.section.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import subway.line.domain.Line;
import subway.station.domain.Station;

public class SectionRepository {
    private static final List<Section> SECTIONS = new ArrayList<>();

    public List<Section> findAll() {
        return Collections.unmodifiableList(SECTIONS);
    }

    public long countByLine(final Line line) {
        return SECTIONS.stream()
                .filter(section -> section.match(line))
                .count()
                ;
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

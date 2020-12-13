package subway.section.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import subway.line.domain.Line;
import subway.station.domain.Station;

public class SectionRepository {
    private static final List<Section> SECTIONS = new ArrayList<>();

    public Section findByLineAndStation(final Line line, final Station station) {
        return SECTIONS.stream()
                .filter(section -> section.match(line, station))
                .findAny()
                .orElseThrow()
                ;
    }

    public List<Section> findAll() {
        return Collections.unmodifiableList(SECTIONS);
    }

    public List<Section> findAllByLineAndSequenceGreaterThanEqual(final Line line,
            final int sequence) {
        return SECTIONS.stream()
                .filter(section -> section.match(line))
                .filter(section -> section.isGreaterThanEqual(sequence))
                .collect(Collectors.toList())
                ;
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

    public void update(final Section section) {
        final Section target = findByLineAndStation(section.getLine(), section.getStation());
        target.update(section);
    }

    public void updateAll(final Collection<Section> sections) {
        for (final Section section : sections) {
            update(section);
        }
    }

    public boolean deleteByLineAndStation(final Line line, final Station station) {
        return SECTIONS.removeIf(section -> section.match(line, station));
    }
}

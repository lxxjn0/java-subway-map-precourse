package subway.section.domain;

import static subway.section.exception.IllegalSectionException.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import subway.line.domain.Line;
import subway.section.exception.IllegalSectionException;
import subway.station.domain.Station;

public class SectionRepository {
    private static final List<Section> SECTIONS = new ArrayList<>();

    public Section findByLineAndStation(final Line line, final Station station) {
        return SECTIONS.stream()
                .filter(section -> section.match(line, station))
                .findAny()
                .orElseThrow(() -> new IllegalSectionException(INVALID_LINE_OR_STATION))
                ;
    }

    public List<Section> findAllByLineOrderBySequence(final Line line) {
        return SECTIONS.stream()
                .filter(section -> section.match(line))
                .sorted(Comparator.comparing(Section::getSequence))
                .collect(Collectors.toUnmodifiableList())
                ;
    }

    public List<Section> findAllByLineAndSequenceGreaterThanEqual(final Line line,
            final int sequence) {
        return SECTIONS.stream()
                .filter(section -> section.match(line))
                .filter(section -> section.isGreaterThanEqual(sequence))
                .collect(Collectors.toList())
                ;
    }

    public boolean existsByStation(final Station station) {
        return SECTIONS.stream()
                .anyMatch(section -> section.match(station))
                ;
    }

    public void save(final Section section) {
        SECTIONS.add(section);
    }

    public void saveAll(final Collection<Section> sections) {
        SECTIONS.addAll(sections);
    }

    public boolean deleteByLineAndStation(final Line line, final Station station) {
        return SECTIONS.removeIf(section -> section.match(line, station));
    }

    public boolean deleteAllByLine(final Line line) {
        return SECTIONS.removeIf(section -> section.match(line));
    }
}

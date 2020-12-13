package subway.section.domain;

import java.util.Collection;
import java.util.List;

import subway.line.domain.Line;
import subway.station.domain.Station;

public interface SectionRepository {
    Section findByLineAndStation(final Line line, final Station station);

    List<Section> findAllByLineOrderBySequence(final Line line);

    List<Section> findAllByLineAndSequenceGreaterThanEqual(final Line line,
            final int sequence);

    boolean existsByStation(final Station station);

    void save(final Section section);

    void saveAll(final Collection<Section> sections);

    boolean deleteByLineAndStation(final Line line, final Station station);

    boolean deleteAllByLine(final Line line);
}

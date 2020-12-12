package subway.section.domain;

import static subway.section.exception.IllegalSectionException.*;

import subway.line.domain.Line;
import subway.section.exception.IllegalSectionException;
import subway.station.domain.Station;

public class Section {
    private static final int SEQUENCE_LOWER_BOUND = 1;

    private final int sequence;
    private final Line line;
    private final Station station;

    public Section(final int sequence, final Line line, final Station station) {
        this.sequence = sequence;
        this.line = line;
        this.station = station;
        validate(sequence);
    }

    private void validate(final int sequence) {
        if (sequence < SEQUENCE_LOWER_BOUND) {
            throw new IllegalSectionException(INVALID_SEQUENCE);
        }
    }

    public boolean match(final Line line, final Station station) {
        return this.line.equals(line) && this.station.equals(station);
    }

    public int getSequence() {
        return sequence;
    }

    public Line getLine() {
        return line;
    }

    public Station getStation() {
        return station;
    }
}

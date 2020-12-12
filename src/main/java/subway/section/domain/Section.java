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

    public static Section of(final int sequence, final String lineName, final String stationName) {
        return new Section(sequence, new Line(lineName), new Station(stationName));
    }

    private void validate(final int sequence) {
        if (sequence < SEQUENCE_LOWER_BOUND) {
            throw new IllegalSectionException(INVALID_SEQUENCE);
        }
    }

    public boolean match(final Line line, final Station station) {
        return this.line.equals(line) && this.station.equals(station);
    }

    public boolean match(final Line line) {
        return this.line.equals(line);
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

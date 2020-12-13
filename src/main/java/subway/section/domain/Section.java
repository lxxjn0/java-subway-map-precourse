package subway.section.domain;

import static subway.section.exception.IllegalSectionException.*;

import subway.line.domain.Line;
import subway.section.exception.IllegalSectionException;
import subway.station.domain.Station;

public class Section {
    public static final long LOWER_BOUND_STATION_SIZE = 2;
    private static final int SEQUENCE_LOWER_BOUND = 1;

    private Line line;
    private Station station;
    private int sequence;

    public Section(final Line line, final Station station, final int sequence) {
        this.line = line;
        this.station = station;
        this.sequence = sequence;
        validate(sequence);
    }

    public static Section of(final String lineName, final String stationName, final int sequence) {
        return new Section(new Line(lineName), new Station(stationName), sequence);
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

    public boolean isGreaterThanEqual(final int sequence) {
        return this.sequence >= sequence;
    }

    public void increaseSequence() {
        sequence++;
    }

    public void update(final Section section) {
        this.line = section.getLine();
        this.station = section.getStation();
        this.sequence = section.getSequence();
        validate(sequence);
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

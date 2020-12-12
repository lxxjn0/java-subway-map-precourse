package subway.section.domain;

import subway.line.domain.Line;
import subway.station.domain.Station;

public class Section {
    private final int sequence;
    private final Line line;
    private final Station station;

    public Section(final int sequence, final Line line, final Station station) {
        this.sequence = sequence;
        this.line = line;
        this.station = station;
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

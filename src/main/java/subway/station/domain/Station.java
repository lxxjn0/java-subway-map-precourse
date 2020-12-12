package subway.station.domain;

import static subway.station.exception.IllegalStationException.*;

public class Station {
    private static final int VALID_NAME_LENGTH = 2;

    private final String name;

    public Station(final String name) {
        this.name = name;
        validate(name);
    }

    private void validate(final String name) {
        if (name.length() < VALID_NAME_LENGTH) {
            throw new IllegalStateException(INVALID_NAME);
        }
    }

    public boolean match(final String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }
}

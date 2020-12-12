package subway.station.domain;

import static subway.station.exception.IllegalStationException.*;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final Station station = (Station)o;
        return Objects.equals(getName(), station.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

package subway.line.domain;

import static subway.line.exception.IllegalLineException.*;

import java.util.Objects;

import subway.line.exception.IllegalLineException;

public class Line {
    private static final int VALID_NAME_LENGTH = 2;

    private String name;

    public Line(final String name) {
        this.name = name;
        validate(name);
    }

    private void validate(final String name) {
        if (name.length() < VALID_NAME_LENGTH) {
            throw new IllegalLineException(INVALID_NAME);
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
        final Line line = (Line)o;
        return Objects.equals(getName(), line.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

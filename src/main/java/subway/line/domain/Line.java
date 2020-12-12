package subway.line.domain;

import static subway.line.exception.IllegalLineException.*;

import subway.line.exception.IllegalLineException;

public class Line {
    private static final int VALID_NAME_LENGTH = 2;

    private final String name;

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
}

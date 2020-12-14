package subway.common.domain;

import static subway.common.exception.IllegalCommandException.*;

import java.util.Arrays;

import subway.common.exception.IllegalCommandException;

public enum Command {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    BACK("B"),
    QUIT("Q");

    final String input;

    Command(final String input) {
        this.input = input;
    }

    public static Command from(final String input) {
        return Arrays.stream(values())
                .filter(command -> command.input.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalCommandException(INVALID))
                ;
    }

    public boolean isBack() {
        return this.equals(BACK);
    }

    public String getInput() {
        return input;
    }
}

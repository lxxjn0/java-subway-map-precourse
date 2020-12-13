package subway.common.domain;

public enum Command {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    BACK("b"),
    QUIT("q");

    final String input;

    Command(final String input) {
        this.input = input;
    }
}

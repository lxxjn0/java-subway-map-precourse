package subway.common.domain;

import static subway.common.domain.Command.*;

public enum Category {
    STATION("역", ONE),
    LINE("노선", TWO),
    SECTION("구간", THREE),
    MAP("지하철 노선도", FOUR);

    final String name;
    final Command command;

    Category(final String name, final Command command) {
        this.name = name;
        this.command = command;
    }
}

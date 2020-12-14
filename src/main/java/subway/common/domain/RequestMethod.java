package subway.common.domain;

import static subway.common.domain.Command.*;

public enum RequestMethod {
    CREATE("등록", ONE),
    DELETE("삭제", TWO),
    READ("조회", THREE);

    final String name;
    final Command command;

    RequestMethod(final String name, final Command command) {
        this.name = name;
        this.command = command;
    }
}

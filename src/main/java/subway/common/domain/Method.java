package subway.common.domain;

import static subway.common.domain.Command.*;

public enum Method {
    CREATE("등록", ONE),
    DELETE("삭제", TWO),
    READ("조회", THREE);

    final String name;
    final Command command;

    Method(final String name, final Command command) {
        this.name = name;
        this.command = command;
    }
}

package subway.common.domain;

import static subway.common.domain.Command.*;
import static subway.common.exception.IllegalCommandException.*;

import java.util.Arrays;

import subway.common.exception.IllegalCommandException;

public enum Method {
    CREATE("등록", ONE),
    DELETE("삭제", TWO),
    READ("조회", THREE),
    NOTHING;

    final String name;
    final Command command;

    Method(final String name, final Command command) {
        this.name = name;
        this.command = command;
    }

    Method() {
        this(null, null);
    }

    public static Method from(final Command command) {
        return Arrays.stream(values())
                .filter(method -> method.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalCommandException(INVALID))
                ;
    }

    public boolean isNothing() {
        return this.equals(NOTHING);
    }

    public String getName() {
        return name;
    }

    public Command getCommand() {
        return command;
    }
}

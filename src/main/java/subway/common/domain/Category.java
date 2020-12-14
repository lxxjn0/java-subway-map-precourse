package subway.common.domain;

import static subway.common.domain.Command.*;
import static subway.common.domain.Method.*;
import static subway.common.exception.IllegalCommandException.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import subway.common.exception.IllegalCommandException;

public enum Category {
    STATION("역", ONE, Arrays.asList(CREATE, DELETE, READ)),
    LINE("노선", TWO, Arrays.asList(CREATE, DELETE, READ)),
    SECTION("구간", THREE, Arrays.asList(CREATE, DELETE)),
    MAP("지하철 노선도", FOUR, Collections.emptyList()),
    TERMINATE("종료", QUIT, Collections.emptyList());

    final String name;
    final Command command;
    final List<Method> methods;

    Category(final String name, final Command command, final List<Method> methods) {
        this.name = name;
        this.command = command;
        this.methods = methods;
    }

    public static Category of(final Command command) {
        return Arrays.stream(values())
                .filter(category -> category.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalCommandException(INVALID))
                ;
    }

    public boolean hasEmptyMethods() {
        return methods.isEmpty();
    }

    public void validate(final Command command) {
        final boolean isAvailable = methods.stream()
                .map(Method::getCommand)
                .anyMatch(value -> value.equals(command));

        if (!isAvailable) {
            throw new IllegalCommandException(INVALID);
        }
    }

    public Map<Command, String> receiveMethodInfo() {
        return methods.stream()
                .collect(Collectors.toMap(
                        Method::getCommand,
                        Method::getName
                ))
                ;
    }

    public String getName() {
        return name;
    }
}

package subway.common.domain;

import static java.util.Arrays.*;
import static subway.common.domain.Command.*;
import static subway.common.domain.RequestMethod.*;

import java.util.Collections;
import java.util.List;

public enum Category {
    STATION("역", ONE, asList(CREATE, DELETE, READ)),
    LINE("노선", TWO, asList(CREATE, DELETE, READ)),
    SECTION("구간", THREE, asList(CREATE, DELETE)),
    MAP("지하철 노선도", FOUR, Collections.emptyList());

    final String name;
    final Command command;
    final List<RequestMethod> requestMethods;

    Category(final String name, final Command command, final List<RequestMethod> requestMethods) {
        this.name = name;
        this.command = command;
        this.requestMethods = requestMethods;
    }
}

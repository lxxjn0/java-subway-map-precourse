package subway.view.config;

import static subway.common.domain.Category.*;
import static subway.common.domain.Method.*;
import static subway.common.exception.IllegalViewException.*;

import java.util.Arrays;

import subway.common.domain.Category;
import subway.common.domain.Method;
import subway.common.exception.IllegalViewException;

public enum ViewMapping {
    STATION_CREATE(STATION, CREATE),
    STATION_DELETE(STATION, DELETE),
    STATION_READ(STATION, READ),
    LINE_CREATE(LINE, CREATE),
    LINE_DELETE(LINE, DELETE),
    LINE_READ(LINE, READ),
    SECTION_CREATE(SECTION, CREATE),
    SECTION_DELETE(SECTION, DELETE),
    SECTION_READ(MAP, NOTHING),
    TERMINATE_PROGRAM(TERMINATE, NOTHING);

    final Category category;
    final Method method;

    ViewMapping(final Category category, final Method method) {
        this.category = category;
        this.method = method;
    }

    public static ViewMapping fromEmptyMethod(final Category category) {
        return Arrays.stream(values())
                .filter(viewMapping -> viewMapping.method.isNothing())
                .filter(viewMapping -> viewMapping.category.equals(category))
                .findAny()
                .orElseThrow(() -> new IllegalViewException(INVALID))
                ;
    }

    public static ViewMapping of(final Category category, final Method method) {
        return Arrays.stream(values())
                .filter(viewMapping -> viewMapping.category.equals(category))
                .filter(viewMapping -> viewMapping.method.equals(method))
                .findAny()
                .orElseThrow(() -> new IllegalViewException(INVALID))
                ;
    }
}

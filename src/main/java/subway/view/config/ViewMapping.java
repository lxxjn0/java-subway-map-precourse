package subway.view.config;

import static subway.common.domain.Category.*;
import static subway.common.domain.RequestMethod.*;

import subway.common.domain.Category;
import subway.common.domain.RequestMethod;

public enum ViewMapping {
    STATION_CREATE(STATION, CREATE),
    STATION_DELETE(STATION, DELETE),
    STATION_READ(STATION, READ),
    LINE_CREATE(LINE, CREATE),
    LINE_DELETE(LINE, DELETE),
    LINE_READ(LINE, READ),
    SECTION_CREATE(SECTION, CREATE),
    SECTION_DELETE(SECTION, DELETE),
    MAP_READ(MAP, NOTHING);

    final Category category;
    final RequestMethod requestMethod;

    ViewMapping(final Category category, final RequestMethod requestMethod) {
        this.category = category;
        this.requestMethod = requestMethod;
    }
}

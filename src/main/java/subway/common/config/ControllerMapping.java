package subway.common.config;

import static subway.line.presentation.LineController.*;
import static subway.section.presentation.SectionController.*;
import static subway.station.presentation.StationController.*;

import subway.common.presentation.Controller;
import subway.line.presentation.LineController;
import subway.section.presentation.SectionController;
import subway.station.presentation.StationController;

public enum ControllerMapping {
    STATION_CONTROLLER(StationController.class, STATION_URI),
    LINE_CONTROLLER(LineController.class, LINE_URI),
    SECTION_CONTROLLER(SectionController.class, SECTION_URI);

    final Class<? extends Controller> clazz;
    final String uri;

    ControllerMapping(final Class<? extends Controller> clazz, final String uri) {
        this.clazz = clazz;
        this.uri = uri;
    }

    public boolean match(final String uri) {
        return this.uri.equals(uri);
    }

    public Class<? extends Controller> getClazz() {
        return clazz;
    }
}

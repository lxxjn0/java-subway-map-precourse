package subway.common.config;

import subway.common.presentation.Controller;
import subway.line.presentation.LineController;
import subway.section.presentation.SectionController;
import subway.station.presentation.StationController;

public enum ControllerMapping {
    STATION_CONTROLLER(StationController.class, "/stations"),
    LINE_CONTROLLER(LineController.class, "/lines"),
    SECTION_CONTROLLER(SectionController.class, "/sections");

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

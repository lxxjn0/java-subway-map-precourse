package subway.common.presentation;

import java.util.Map;

import subway.common.config.ControllerConfigurer;
import subway.common.config.ControllerMapping;

public class ControllerHandler {
    private static final Map<ControllerMapping, Controller> CONTROLLERS = ControllerConfigurer.generate();

    private ControllerHandler() {
    }

    public static Controller getController(final String uri) {
        return CONTROLLERS.entrySet().stream()
                .filter(entry -> entry.getKey().match(uri))
                .map(Map.Entry::getValue)
                .findAny()
                .orElseThrow()
                ;
    }
}

package subway.common.presentation;

import static subway.common.exception.IllegalRequestException.*;

import java.util.Map;

import subway.common.application.AbstractRequest;
import subway.common.config.ControllerConfigurer;
import subway.common.config.ControllerMapping;
import subway.common.exception.IllegalRequestException;

public class ControllerHandler {
    private static final Map<ControllerMapping, Controller> CONTROLLERS = ControllerConfigurer.generate();

    private ControllerHandler() {
    }

    public static Controller getController(final AbstractRequest<?> request) {
        return CONTROLLERS.entrySet().stream()
                .filter(entry -> entry.getKey().match(request.getUri()))
                .map(Map.Entry::getValue)
                .findAny()
                .orElseThrow(() -> new IllegalRequestException(INVALID))
                ;
    }
}

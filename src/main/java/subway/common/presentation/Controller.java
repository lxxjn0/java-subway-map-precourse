package subway.common.presentation;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;

public interface Controller {
    ResponseEntity<?> doService(final AbstractRequest<?> request);
}

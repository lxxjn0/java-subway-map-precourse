package subway.view.config;

import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;

public class TerminateView<T, R> extends View<T, R> {
    public TerminateView(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public AbstractRequest<T> getRequest() {
        return null;
    }

    @Override
    public void renderResponse(final ResponseEntity<R> responseEntity) {

    }
}

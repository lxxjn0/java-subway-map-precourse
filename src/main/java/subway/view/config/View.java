package subway.view.config;

import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;

public abstract class View<T, R> {
    protected final Scanner scanner;

    protected View(final Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract AbstractRequest<T> getRequest();

    public abstract void renderResponse(final ResponseEntity<R> responseEntity);
}

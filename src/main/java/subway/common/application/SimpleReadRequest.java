package subway.common.application;

import static subway.common.domain.Method.*;

import subway.common.domain.Method;

public class SimpleReadRequest<T> extends AbstractRequest<T> {
    private SimpleReadRequest(final String uri, final Method method) {
        super(uri, method);
    }

    public SimpleReadRequest(final String uri) {
        this(uri, READ);
    }
}

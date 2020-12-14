package subway.common.application;

import static subway.common.domain.RequestMethod.*;

import subway.common.domain.RequestMethod;

public class SimpleReadRequest<T> extends AbstractRequest<T> {
    private SimpleReadRequest(final String uri, final RequestMethod requestMethod) {
        super(uri, requestMethod);
    }

    public SimpleReadRequest(final String uri) {
        this(uri, READ);
    }
}

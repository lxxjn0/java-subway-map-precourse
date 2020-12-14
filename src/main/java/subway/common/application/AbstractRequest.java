package subway.common.application;

import subway.common.domain.RequestMethod;

public abstract class AbstractRequest<T> {
    private String uri;
    private RequestMethod method;

    protected AbstractRequest(final String uri, final RequestMethod requestMethod) {
        this.uri = uri;
        this.method = requestMethod;
    }

    public T toEntity() {
        throw new UnsupportedOperationException();
    }

    public String getUri() {
        return uri;
    }

    public RequestMethod getMethod() {
        return method;
    }
}

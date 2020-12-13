package subway.common.application;

import subway.common.Method;

public abstract class AbstractRequest<T> {
    private String uri;
    private Method method;

    protected AbstractRequest(final String uri, final Method method) {
        this.uri = uri;
        this.method = method;
    }

    public T toEntity() {
        throw new UnsupportedOperationException();
    }

    public String getUri() {
        return uri;
    }

    public Method getMethod() {
        return method;
    }
}

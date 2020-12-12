package subway.common.application;

public abstract class AbstractRequest<T> {
    public T toEntity() {
        throw new UnsupportedOperationException();
    }
}

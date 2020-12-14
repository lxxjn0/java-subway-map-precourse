package subway.common.application;

public class ExceptionResponse<T extends IllegalArgumentException> {
    private final T exception;

    public ExceptionResponse(final T exception) {
        this.exception = exception;
    }

    public T getException() {
        return exception;
    }
}

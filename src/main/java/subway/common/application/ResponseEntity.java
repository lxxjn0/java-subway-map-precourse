package subway.common.application;

public class ResponseEntity<T> {
    private T response;

    private ResponseEntity(final T response) {
        this.response = response;
    }

    public static <R> ResponseEntity<R> build(final R response) {
        return new ResponseEntity<>(response);
    }

    public static ResponseEntity<Void> build() {
        return new ResponseEntity<>(null);
    }

    public T getResponse() {
        return response;
    }
}

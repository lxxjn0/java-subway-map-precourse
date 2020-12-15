package subway.common.exception;

public class IllegalRequestException extends IllegalArgumentException {
    public static final String INVALID = "유효하지 않은 요청입니다.";

    public IllegalRequestException(final String s) {
        super(s);
    }
}

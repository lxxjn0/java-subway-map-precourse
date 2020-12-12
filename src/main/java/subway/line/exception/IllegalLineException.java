package subway.line.exception;

public class IllegalLineException extends IllegalArgumentException {
    public static final String INVALID_NAME = "유효하지 않은 노선 이름입니다.";

    public IllegalLineException(final String s) {
        super(s);
    }
}

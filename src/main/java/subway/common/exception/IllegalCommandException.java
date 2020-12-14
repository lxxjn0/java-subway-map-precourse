package subway.common.exception;

public class IllegalCommandException extends IllegalArgumentException {
    public static final String INVALID_COMMAND = "선택할 수 없는 기능입니다.";

    public IllegalCommandException(final String s) {
        super(s);
    }
}

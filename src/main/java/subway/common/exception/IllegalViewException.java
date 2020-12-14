package subway.common.exception;

public class IllegalViewException extends IllegalArgumentException {
    public static final String INVALID = "선택할 수 없는 기능입니다.";

    public IllegalViewException(final String s) {
        super(s);
    }
}

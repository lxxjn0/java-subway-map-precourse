package subway.section.exception;

public class IllegalSectionException extends IllegalArgumentException {
    public static final String INVALID_SEQUENCE = "유효하지 않은 구간 번호입니다.";

    public IllegalSectionException(final String s) {
        super(s);
    }
}

package subway.common.exception;

public class IllegalCategoryException extends IllegalArgumentException {
    public static final String INVALID = "선택할 수 없는 기능입니다.";

    public IllegalCategoryException(final String s) {
        super(s);
    }
}

package subway.section.exception;

public class IllegalSectionException extends IllegalArgumentException {
    public static final String INVALID_SEQUENCE = "유효하지 않은 구간 번호입니다.";
    public static final String CONSTRAINT_STATION_SIZE = "노선에는 적어도 2개 이상의 역이 존재해야 합니다.";

    public IllegalSectionException(final String s) {
        super(s);
    }
}

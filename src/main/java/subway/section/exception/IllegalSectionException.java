package subway.section.exception;

public class IllegalSectionException extends IllegalArgumentException {
    public static final String INVALID_SEQUENCE = "유효하지 않은 구간 번호입니다.";
    public static final String INVALID_LINE_OR_STATION = "노선과 역에 일치하는 구간이 존재하지 않습니다.";
    public static final String CONSTRAINT_STATION_SIZE = "노선에는 적어도 2개 이상의 역이 존재해야 합니다.";
    public static final String NOT_EXISTS = "존재하지 않는 구간입니다.";

    public IllegalSectionException(final String s) {
        super(s);
    }
}

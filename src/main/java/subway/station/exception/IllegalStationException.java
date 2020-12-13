package subway.station.exception;

public class IllegalStationException extends IllegalArgumentException {
    public static final String INVALID_NAME = "유효하지 않은 역 이름입니다.";
    public static final String ALREADY_EXISTS = "이미 존재하는 역입니다.";
    public static final String NOT_EXISTS = "존재하지 않는 역입니다.";
    public static final String REGISTERED_SECTION = "구간에 등록되어 있는 역입니다.";

    public IllegalStationException(final String s) {
        super(s);
    }
}

package subway.station.exception;

public class IllegalStationException extends IllegalArgumentException {
    public static final String INVALID_NAME = "유효하지 않은 역 이름입니다.";

    public IllegalStationException(final String s) {
        super(s);
    }
}

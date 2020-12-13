package subway.line.application;

import subway.common.application.AbstractRequest;
import subway.line.domain.Line;

public class LineRequest extends AbstractRequest<Line> {
    private String lineName;
    private String upLastStationName;
    private String downLastStationName;

    public LineRequest(final String lineName, final String upLastStationName,
            final String downLastStationName) {
        this.lineName = lineName;
        this.upLastStationName = upLastStationName;
        this.downLastStationName = downLastStationName;
    }

    @Override
    public Line toEntity() {
        return new Line(lineName);
    }

    public String getLineName() {
        return lineName;
    }

    public String getUpLastStationName() {
        return upLastStationName;
    }

    public String getDownLastStationName() {
        return downLastStationName;
    }
}

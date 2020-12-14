package subway.line.application;

import static subway.common.domain.RequestMethod.*;
import static subway.line.presentation.LineController.*;

import subway.common.application.AbstractRequest;
import subway.common.domain.RequestMethod;
import subway.line.domain.Line;

public class LineRequest extends AbstractRequest<Line> {
    private String lineName;
    private String upLastStationName;
    private String downLastStationName;

    private LineRequest(
            final String uri,
            final RequestMethod requestMethod,
            final String lineName,
            final String upLastStationName,
            final String downLastStationName
    ) {
        super(uri, requestMethod);
        this.lineName = lineName;
        this.upLastStationName = upLastStationName;
        this.downLastStationName = downLastStationName;
    }

    public static LineRequest of(
            final String lineName,
            final String upLastStationName,
            final String downLastStationName
    ) {
        return new LineRequest(LINE_URI, CREATE, lineName, upLastStationName, downLastStationName);
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

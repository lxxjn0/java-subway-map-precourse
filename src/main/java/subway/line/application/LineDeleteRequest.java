package subway.line.application;

import subway.common.application.AbstractRequest;
import subway.line.domain.Line;

public class LineDeleteRequest extends AbstractRequest<Line> {
    private String name;

    public LineDeleteRequest(final String name) {
        this.name = name;
    }

    @Override
    public Line toEntity() {
        return new Line(name);
    }

    public String getName() {
        return name;
    }
}

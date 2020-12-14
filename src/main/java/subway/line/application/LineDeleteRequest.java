package subway.line.application;

import subway.common.application.AbstractRequest;
import subway.common.domain.RequestMethod;
import subway.line.domain.Line;

public class LineDeleteRequest extends AbstractRequest<Line> {
    private String name;

    private LineDeleteRequest(
            final String uri,
            final RequestMethod requestMethod,
            final String name
    ) {
        super(uri, requestMethod);
        this.name = name;
    }

    public static LineDeleteRequest of(final String name) {
        return new LineDeleteRequest("/lines", RequestMethod.DELETE, name);
    }

    @Override
    public Line toEntity() {
        return new Line(name);
    }

    public String getName() {
        return name;
    }
}

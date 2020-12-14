package subway.line.application;

import static subway.common.domain.Method.*;
import static subway.line.presentation.LineController.*;

import subway.common.application.AbstractRequest;
import subway.common.domain.Method;
import subway.line.domain.Line;

public class LineDeleteRequest extends AbstractRequest<Line> {
    private String name;

    private LineDeleteRequest(
            final String uri,
            final Method method,
            final String name
    ) {
        super(uri, method);
        this.name = name;
    }

    public static LineDeleteRequest of(final String name) {
        return new LineDeleteRequest(LINE_URI, DELETE, name);
    }

    @Override
    public Line toEntity() {
        return new Line(name);
    }

    public String getName() {
        return name;
    }
}

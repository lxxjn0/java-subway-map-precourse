package subway.line.application;

import java.util.List;
import java.util.stream.Collectors;

import subway.line.domain.Line;

public class LineResponse {
    private String name;

    private LineResponse(final String name) {
        this.name = name;
    }

    public static LineResponse from(final Line line) {
        return new LineResponse(line.getName());
    }

    public static List<LineResponse> toList(final List<Line> lines) {
        return lines.stream()
                .map(LineResponse::from)
                .collect(Collectors.toList())
                ;
    }

    public String getName() {
        return name;
    }
}

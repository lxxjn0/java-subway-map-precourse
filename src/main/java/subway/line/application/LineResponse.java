package subway.line.application;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import subway.line.domain.Line;

public class LineResponse implements Comparable<LineResponse> {
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

    @Override
    public int compareTo(final LineResponse o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final LineResponse that = (LineResponse)o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

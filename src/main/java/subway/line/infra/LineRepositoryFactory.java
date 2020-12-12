package subway.line.infra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.line.domain.Line;
import subway.line.domain.LineRepository;

public class LineRepositoryFactory {
    public static final Line 이호선 = new Line("2호선");
    public static final Line 삼호선 = new Line("3호선");
    public static final Line 신분당선 = new Line("신분당선");
    private static final List<Line> initializedLines = new ArrayList<>();

    static {
        final List<Line> lines = Arrays.asList(
                이호선,
                삼호선,
                신분당선
        );
        initializedLines.addAll(lines);
    }

    private LineRepositoryFactory() {
    }

    public static LineRepository generate() {
        final LineRepository lineRepository = new LineRepository();

        lineRepository.saveAll(initializedLines);
        return lineRepository;
    }
}

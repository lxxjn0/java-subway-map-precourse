package subway.section.application;

import java.util.List;
import java.util.stream.Collectors;

import subway.common.application.AbstractRequest;
import subway.common.domain.Method;
import subway.line.domain.Line;

public class SectionViewRequest extends AbstractRequest<List<Line>> {
    private List<String> lineNames;

    private SectionViewRequest(
            final String uri,
            final Method method,
            final List<String> lineNames
    ) {
        super(uri, method);
        this.lineNames = lineNames;
    }

    public static SectionViewRequest of(final List<String> lineNames) {
        return new SectionViewRequest("/sections", Method.READ, lineNames);
    }

    @Override
    public List<Line> toEntity() {
        return lineNames.stream()
                .map(Line::new)
                .collect(Collectors.toList())
                ;
    }

    public List<String> getLineNames() {
        return lineNames;
    }
}

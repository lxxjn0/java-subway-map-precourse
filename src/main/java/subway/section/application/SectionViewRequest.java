package subway.section.application;

import java.util.List;
import java.util.stream.Collectors;

import subway.common.application.AbstractRequest;
import subway.line.domain.Line;

public class SectionViewRequest extends AbstractRequest<List<Line>> {
    private List<String> lineNames;

    public SectionViewRequest(final List<String> lineNames) {
        this.lineNames = lineNames;
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

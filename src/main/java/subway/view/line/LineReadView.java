package subway.view.line;

import static subway.line.presentation.LineController.*;

import java.util.List;
import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;
import subway.common.application.SimpleReadRequest;
import subway.line.application.LineResponse;
import subway.line.domain.Line;
import subway.view.config.View;

public class LineReadView extends View<Line> {
    public LineReadView(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public AbstractRequest<Line> getRequest() {
        return new SimpleReadRequest<>(LINE_URI);
    }

    @Override
    public void renderResponse(final ResponseEntity<?> responseEntity) {
        final List<?> responses = (List<?>)responseEntity.getResponse();

        System.out.println("## 노선 목록");
        for (final Object response : responses) {
            System.out.printf("[INFO] %s%n", ((LineResponse)response).getName());
        }
        System.out.println();
    }
}

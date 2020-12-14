package subway.view.line;

import static subway.line.exception.IllegalLineException.*;

import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;
import subway.line.application.LineDeleteRequest;
import subway.line.application.LineDeleteResponse;
import subway.line.domain.Line;
import subway.view.config.View;

public class LineDeleteView extends View<Line, LineDeleteResponse> {
    public LineDeleteView(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public AbstractRequest<Line> getRequest() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        final String name = scanner.nextLine();
        System.out.println();

        return LineDeleteRequest.of(name);
    }

    @Override
    public void renderResponse(final ResponseEntity<LineDeleteResponse> responseEntity) {
        final LineDeleteResponse response = responseEntity.getResponse();

        if (response.isDeleted()) {
            System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
            System.out.println();
        }

        System.out.printf("[ERROR] %s%n", NOT_EXISTS);
        System.out.println();
    }
}

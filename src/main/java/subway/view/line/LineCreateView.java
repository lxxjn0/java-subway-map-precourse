package subway.view.line;

import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;
import subway.line.application.LineRequest;
import subway.line.domain.Line;
import subway.view.config.View;

public class LineCreateView extends View<Line> {
    public LineCreateView(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public AbstractRequest<Line> getRequest() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        final String lineName = scanner.nextLine();
        System.out.println();

        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        final String upLastStationName = scanner.nextLine();
        System.out.println();

        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        final String downLastStationName = scanner.nextLine();
        System.out.println();

        return LineRequest.of(lineName, upLastStationName, downLastStationName);
    }

    @Override
    public void renderResponse(final ResponseEntity<?> responseEntity) {
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
        System.out.println();
    }
}

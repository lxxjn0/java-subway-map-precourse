package subway.view.station;

import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;
import subway.station.application.StationRequest;
import subway.station.domain.Station;
import subway.view.config.View;

public class StationCreateView extends View<Station, Void> {
    public StationCreateView(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public AbstractRequest<Station> getRequest() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        System.out.println();

        return StationRequest.of(scanner.nextLine());
    }

    @Override
    public void renderResponse(final ResponseEntity<Void> responseEntity) {
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
        System.out.println();
    }
}

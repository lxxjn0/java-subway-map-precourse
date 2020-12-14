package subway.view.station;

import static subway.station.exception.IllegalStationException.*;

import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;
import subway.station.application.StationDeleteRequest;
import subway.station.application.StationDeleteResponse;
import subway.station.domain.Station;
import subway.view.config.View;

public class StationDeleteView extends View<Station, StationDeleteResponse> {
    public StationDeleteView(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public AbstractRequest<Station> getRequest() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        final String name = scanner.nextLine();
        System.out.println();

        return StationDeleteRequest.of(name);
    }

    @Override
    public void renderResponse(final ResponseEntity<StationDeleteResponse> responseEntity) {
        final StationDeleteResponse response = responseEntity.getResponse();

        if (response.isDeleted()) {
            System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
            System.out.println();
            return;
        }

        System.out.printf("[ERROR] %s%n", NOT_EXISTS);
        System.out.println();
    }
}

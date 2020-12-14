package subway.view.station;

import static subway.station.presentation.StationController.*;

import java.util.List;
import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;
import subway.common.application.SimpleReadRequest;
import subway.station.application.StationResponse;
import subway.station.domain.Station;
import subway.view.config.View;

public class StationReadView extends View<Station, List<StationResponse>> {
    public StationReadView(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public AbstractRequest<Station> getRequest() {
        return new SimpleReadRequest<>(STATION_URI);
    }

    @Override
    public void renderResponse(final ResponseEntity<List<StationResponse>> responseEntity) {
        final List<StationResponse> responses = responseEntity.getResponse();

        System.out.println("## 노선 목록");
        for (final StationResponse response : responses) {
            System.out.printf("[INFO] %s%n", response.getName());
        }
        System.out.println();
    }
}

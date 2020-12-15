package subway.view.station;

import static subway.common.domain.Category.*;
import static subway.station.exception.IllegalStationException.*;
import static subway.view.config.ViewMessageFixture.*;

import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;
import subway.station.application.StationDeleteRequest;
import subway.station.application.StationDeleteResponse;
import subway.station.domain.Station;
import subway.view.config.View;

public class StationDeleteView extends View<Station> {
    public StationDeleteView(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public AbstractRequest<Station> getRequest() {
        System.out.printf(DELETE_INPUT_FORMAT, STATION.getName());
        final String name = scanner.nextLine();
        System.out.println();

        return StationDeleteRequest.of(name);
    }

    @Override
    public void renderResponse(final ResponseEntity<?> responseEntity) {
        final StationDeleteResponse response = (StationDeleteResponse)responseEntity.getResponse();

        if (response.isDeleted()) {
            System.out.printf(DELETE_COMPLETE_FORMAT, STATION.getName());
            return;
        }

        System.out.printf(ERROR_FORMAT, NOT_EXISTS);
    }
}

package subway.view.station;

import static subway.common.domain.Category.*;
import static subway.station.presentation.StationController.*;
import static subway.view.config.ViewMessageFixture.*;

import java.util.List;
import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;
import subway.common.application.SimpleReadRequest;
import subway.station.application.StationResponse;
import subway.station.domain.Station;
import subway.view.config.View;

public class StationReadView extends View<Station> {
    public StationReadView(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public AbstractRequest<Station> getRequest() {
        return new SimpleReadRequest<>(STATION_URI);
    }

    @Override
    public void renderResponse(final ResponseEntity<?> responseEntity) {
        final List<?> responses = (List<?>)responseEntity.getResponse();

        System.out.printf(READ_LIST_FORMAT, STATION.getName());
        for (final Object response : responses) {
            System.out.printf(ERROR_FORMAT, ((StationResponse)response).getName());
        }
        System.out.println();
    }
}

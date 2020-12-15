package subway.view.station;

import static subway.common.domain.Category.*;
import static subway.view.config.ViewMessageFixture.*;

import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;
import subway.station.application.StationRequest;
import subway.station.domain.Station;
import subway.view.config.View;

public class StationCreateView extends View<Station> {
    public StationCreateView(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public AbstractRequest<Station> getRequest() {
        System.out.printf(CREATE_INPUT_FORMAT, STATION.getName());
        final String name = scanner.nextLine();
        System.out.println();

        return StationRequest.of(name);
    }

    @Override
    public void renderResponse(final ResponseEntity<?> responseEntity) {
        System.out.printf(CREATE_COMPLETE_FORMAT, STATION.getName());
    }
}

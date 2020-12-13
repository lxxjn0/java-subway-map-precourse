package subway.station.presentation;

import java.util.List;

import subway.common.application.ResponseEntity;
import subway.common.presentation.Controller;
import subway.station.application.StationDeleteRequest;
import subway.station.application.StationDeleteResponse;
import subway.station.application.StationDeleteService;
import subway.station.application.StationRequest;
import subway.station.application.StationResponse;
import subway.station.application.StationService;

public class StationController extends Controller {
    private final StationService stationService;
    private final StationDeleteService stationDeleteService;

    public StationController(final StationService stationService,
            final StationDeleteService stationDeleteService) {
        this.stationService = stationService;
        this.stationDeleteService = stationDeleteService;
    }

    public ResponseEntity<Void> create(final StationRequest request) {
        stationService.create(request);
        return ResponseEntity.build();
    }

    public ResponseEntity<List<StationResponse>> showAll() {
        final List<StationResponse> responses = stationService.showAll();
        return ResponseEntity.build(responses);
    }

    public ResponseEntity<StationDeleteResponse> removeByName(final StationDeleteRequest request) {
        final StationDeleteResponse response = stationDeleteService.removeByName(request);
        return ResponseEntity.build(response);
    }
}

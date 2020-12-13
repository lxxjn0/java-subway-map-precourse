package subway.line.presentation;

import java.util.List;

import subway.common.application.ResponseEntity;
import subway.common.presentation.Controller;
import subway.line.application.LineDeleteRequest;
import subway.line.application.LineDeleteResponse;
import subway.line.application.LineRequest;
import subway.line.application.LineResponse;
import subway.line.application.LineService;

public class LineController extends Controller {
    private final LineService lineService;

    public LineController(final LineService lineService) {
        this.lineService = lineService;
    }

    public ResponseEntity<Void> create(final LineRequest request) {
        lineService.create(request);
        return ResponseEntity.build();
    }

    public ResponseEntity<List<LineResponse>> showAll() {
        final List<LineResponse> responses = lineService.showAll();
        return ResponseEntity.build(responses);
    }

    public ResponseEntity<LineDeleteResponse> deleteByName(final LineDeleteRequest request) {
        final LineDeleteResponse response = lineService.deleteByName(request);
        return ResponseEntity.build(response);
    }
}

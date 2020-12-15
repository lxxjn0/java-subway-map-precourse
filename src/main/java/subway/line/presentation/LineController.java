package subway.line.presentation;

import static subway.common.exception.IllegalRequestException.*;

import java.util.List;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;
import subway.common.domain.Method;
import subway.common.exception.IllegalRequestException;
import subway.common.presentation.Controller;
import subway.line.application.LineDeleteRequest;
import subway.line.application.LineDeleteResponse;
import subway.line.application.LineRequest;
import subway.line.application.LineResponse;
import subway.line.application.LineService;

public class LineController implements Controller {
    public static final String LINE_URI = "/lines";

    private final LineService lineService;

    public LineController(final LineService lineService) {
        this.lineService = lineService;
    }

    @Override
    public ResponseEntity<?> doService(final AbstractRequest<?> request) {
        final Method method = request.getMethod();

        if (method.isCreate()) {
            return create((LineRequest)request);
        }

        if (method.isRead()) {
            return showAll();
        }

        if (method.isDelete()) {
            return deleteByName((LineDeleteRequest)request);
        }

        throw new IllegalRequestException(INVALID);
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

package subway.section.presentation;

import static subway.common.exception.IllegalRequestException.*;

import java.util.List;
import java.util.Map;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;
import subway.common.domain.Method;
import subway.common.exception.IllegalRequestException;
import subway.common.presentation.Controller;
import subway.line.application.LineResponse;
import subway.section.application.SectionDeleteRequest;
import subway.section.application.SectionDeleteResponse;
import subway.section.application.SectionRequest;
import subway.section.application.SectionResponse;
import subway.section.application.SectionService;

public class SectionController implements Controller {
    public static final String SECTION_URI = "/sections";

    private final SectionService sectionService;

    public SectionController(final SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @Override
    public ResponseEntity<?> doService(final AbstractRequest<?> request) {
        final Method method = request.getMethod();

        if (method.isCreate()) {
            return create((SectionRequest)request);
        }

        if (method.isRead()) {
            return showAllByEachLine();
        }

        if (method.isDelete()) {
            return removeByLineAndStation((SectionDeleteRequest)request);
        }

        throw new IllegalRequestException(INVALID);
    }

    public ResponseEntity<Void> create(final SectionRequest request) {
        sectionService.create(request);
        return ResponseEntity.build();
    }

    public ResponseEntity<Map<LineResponse, List<SectionResponse>>> showAllByEachLine() {
        final Map<LineResponse, List<SectionResponse>> responses = sectionService.showAllByEachLine();
        return ResponseEntity.build(responses);
    }

    public ResponseEntity<SectionDeleteResponse> removeByLineAndStation(
            final SectionDeleteRequest request) {
        final SectionDeleteResponse response = sectionService.removeByLineAndStation(request);
        return ResponseEntity.build(response);
    }
}

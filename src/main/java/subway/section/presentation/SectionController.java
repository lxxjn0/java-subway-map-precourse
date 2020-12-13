package subway.section.presentation;

import java.util.List;
import java.util.Map;

import subway.common.application.ResponseEntity;
import subway.common.presentation.Controller;
import subway.line.application.LineResponse;
import subway.section.application.SectionDeleteRequest;
import subway.section.application.SectionDeleteResponse;
import subway.section.application.SectionRequest;
import subway.section.application.SectionResponse;
import subway.section.application.SectionService;
import subway.section.application.SectionViewRequest;

public class SectionController extends Controller {
    private final SectionService sectionService;

    public SectionController(final SectionService sectionService) {
        this.sectionService = sectionService;
    }

    public ResponseEntity<Void> create(final SectionRequest request) {
        sectionService.create(request);
        return ResponseEntity.build();
    }

    public ResponseEntity<Map<LineResponse, List<SectionResponse>>> showAllByEachLine(
            final SectionViewRequest request) {
        final Map<LineResponse, List<SectionResponse>> responses = sectionService.showAllByEachLine(
                request);
        return ResponseEntity.build(responses);
    }

    public ResponseEntity<SectionDeleteResponse> removeByLineAndStation(
            final SectionDeleteRequest request) {
        final SectionDeleteResponse response = sectionService.removeByLineAndStation(request);
        return ResponseEntity.build(response);
    }
}

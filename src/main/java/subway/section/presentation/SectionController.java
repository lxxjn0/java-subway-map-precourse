package subway.section.presentation;

import subway.common.application.ResponseEntity;
import subway.common.presentation.Controller;
import subway.section.application.SectionDeleteRequest;
import subway.section.application.SectionDeleteResponse;
import subway.section.application.SectionRequest;
import subway.section.application.SectionService;

public class SectionController extends Controller {
    private final SectionService sectionService;

    public SectionController(final SectionService sectionService) {
        this.sectionService = sectionService;
    }

    public ResponseEntity<Void> create(final SectionRequest request) {
        sectionService.create(request);
        return ResponseEntity.build();
    }

    public ResponseEntity<SectionDeleteResponse> removeByLineAndStation(
            final SectionDeleteRequest request) {
        final SectionDeleteResponse response = sectionService.removeByLineAndStation(request);
        return ResponseEntity.build(response);
    }
}

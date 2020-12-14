package subway.view.section;

import static subway.section.presentation.SectionController.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;
import subway.common.application.SimpleReadRequest;
import subway.line.application.LineResponse;
import subway.section.application.SectionResponse;
import subway.section.domain.Section;
import subway.view.config.View;

public class SectionReadView extends View<Section, Map<LineResponse, List<SectionResponse>>> {
    public SectionReadView(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public AbstractRequest<Section> getRequest() {
        return new SimpleReadRequest<>(SECTION_URI);
    }

    @Override
    public void renderResponse(
            final ResponseEntity<Map<LineResponse, List<SectionResponse>>> responseEntity) {
        final Map<LineResponse, List<SectionResponse>> responses = responseEntity.getResponse();

        System.out.println("## 지하철 노선도");
        for (final Map.Entry<LineResponse, List<SectionResponse>> entry : responses.entrySet()) {
            final LineResponse lineResponse = entry.getKey();
            final List<SectionResponse> sectionResponses = entry.getValue();

            System.out.printf("[INFO] %s%n", lineResponse.getName());
            System.out.println("[INFO] ---");
            printSections(sectionResponses);
            System.out.println();
        }
        System.out.println();
    }

    private void printSections(final List<SectionResponse> sectionResponses) {
        for (final SectionResponse sectionResponse : sectionResponses) {
            System.out.printf("[INFO] %s%n", sectionResponse.getStationResponse().getName());
        }
    }
}

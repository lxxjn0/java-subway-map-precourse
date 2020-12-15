package subway.view.section;

import static subway.section.presentation.SectionController.*;
import static subway.view.config.ViewMessageFixture.*;

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

public class SectionReadView extends View<Section> {
    public SectionReadView(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public AbstractRequest<Section> getRequest() {
        return new SimpleReadRequest<>(SECTION_URI);
    }

    @Override
    public void renderResponse(final ResponseEntity<?> responseEntity) {
        final Map<?, ?> responses = (Map<?, ?>)responseEntity.getResponse();

        System.out.println(MAP_SCREEN_MESSAGE);
        for (final Map.Entry<?, ?> entry : responses.entrySet()) {
            final LineResponse lineResponse = (LineResponse)entry.getKey();
            final List<?> sectionResponses = (List<?>)entry.getValue();

            System.out.printf(INFO_FORMAT, lineResponse.getName());
            System.out.println(INFO_SEPARATOR_MESSAGE);
            printSections(sectionResponses);
            System.out.println();
        }
        System.out.println();
    }

    private void printSections(final List<?> sectionResponses) {
        for (final Object sectionResponse : sectionResponses) {
            final String name = ((SectionResponse)sectionResponse).getStationResponse().getName();
            System.out.printf(INFO_FORMAT, name);
        }
    }
}

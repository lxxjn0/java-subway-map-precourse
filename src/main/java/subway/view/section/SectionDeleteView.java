package subway.view.section;

import static subway.common.domain.Category.*;
import static subway.section.exception.IllegalSectionException.*;
import static subway.view.config.ViewMessageFixture.*;

import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;
import subway.section.application.SectionDeleteRequest;
import subway.section.application.SectionDeleteResponse;
import subway.section.domain.Section;
import subway.view.config.View;

public class SectionDeleteView extends View<Section> {
    public SectionDeleteView(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public AbstractRequest<Section> getRequest() {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        final String lineName = scanner.nextLine();
        System.out.println();

        System.out.println("## 삭제할 구간의 역을 입력하세요.");
        final String stationName = scanner.nextLine();
        System.out.println();

        return SectionDeleteRequest.of(lineName, stationName);
    }

    @Override
    public void renderResponse(final ResponseEntity<?> responseEntity) {
        final SectionDeleteResponse response = (SectionDeleteResponse)responseEntity.getResponse();

        if (response.isDeleted()) {
            System.out.printf(DELETE_COMPLETE_FORMAT, SECTION.getName());
            return;
        }

        System.out.printf(ERROR_FORMAT, NOT_EXISTS);
    }
}

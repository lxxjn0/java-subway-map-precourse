package subway.view.section;

import static subway.section.exception.IllegalSectionException.*;

import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;
import subway.section.application.SectionDeleteRequest;
import subway.section.application.SectionDeleteResponse;
import subway.section.domain.Section;
import subway.view.config.View;

public class SectionDeleteView extends View<Section, SectionDeleteResponse> {
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
    public void renderResponse(final ResponseEntity<SectionDeleteResponse> responseEntity) {
        final SectionDeleteResponse response = responseEntity.getResponse();

        if (response.isDeleted()) {
            System.out.println("[INFO] 구간이 삭제되었습니다.");
            System.out.println();
            return;
        }

        System.out.printf("[ERROR] %s%n", NOT_EXISTS);
        System.out.println();
    }
}

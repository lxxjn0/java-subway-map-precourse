package subway.view.section;

import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.application.ResponseEntity;
import subway.section.application.SectionRequest;
import subway.section.domain.Section;
import subway.view.config.View;

public class SectionCreateView extends View<Section> {
    public SectionCreateView(final Scanner scanner) {
        super(scanner);
    }

    @Override
    public AbstractRequest<Section> getRequest() {
        System.out.println("## 노선을 입력하세요.");
        final String lineName = scanner.nextLine();
        System.out.println();

        System.out.println("## 역이름을 입력하세요.");
        final String stationName = scanner.nextLine();
        System.out.println();

        System.out.println("## 순서를 입력하세요.");
        final int sequence = inputSequence();
        System.out.println();

        return SectionRequest.of(sequence, lineName, stationName);
    }

    private int inputSequence() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return Integer.MIN_VALUE; // invalid sequence number
        }
    }

    @Override
    public void renderResponse(final ResponseEntity<?> responseEntity) {
        System.out.println("## [INFO] 구간이 등록되었습니다.");
        System.out.println();
    }
}

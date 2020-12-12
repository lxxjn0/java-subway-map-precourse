package subway.infra.factory;

import static subway.infra.factory.LineRepositoryFactory.*;
import static subway.infra.factory.StationRepositoryFactory.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.domain.Section;
import subway.domain.SectionRepository;

public class SectionRepositoryFactory {
    static final Section 이호선_교대역_1 = new Section(1, 이호선, 교대역);
    static final Section 이호선_강남역_2 = new Section(2, 이호선, 강남역);
    static final Section 이호선_역삼역_3 = new Section(3, 이호선, 역삼역);
    static final Section 삼호선_교대역_1 = new Section(1, 삼호선, 교대역);
    static final Section 삼호선_남부터미널역_2 = new Section(2, 삼호선, 남부터미널역);
    static final Section 삼호선_양재역_3 = new Section(3, 삼호선, 양재역);
    static final Section 삼호선_매봉역_4 = new Section(4, 삼호선, 매봉역);
    static final Section 신분당선_강남역_1 = new Section(1, 신분당선, 강남역);
    static final Section 신분당선_양재역_2 = new Section(2, 신분당선, 양재역);
    static final Section 신분당선_양재시민의숲역_3 = new Section(3, 신분당선, 양재시민의숲역);
    private static final List<Section> initializedSections = new ArrayList<>();

    static {
        final List<Section> sections = Arrays.asList(
                이호선_교대역_1,
                이호선_강남역_2,
                이호선_역삼역_3,
                삼호선_교대역_1,
                삼호선_남부터미널역_2,
                삼호선_양재역_3,
                삼호선_매봉역_4,
                신분당선_강남역_1,
                신분당선_양재역_2,
                신분당선_양재시민의숲역_3
        );
        initializedSections.addAll(sections);
    }

    private SectionRepositoryFactory() {
    }

    public static SectionRepository generate() {
        final SectionRepository sectionRepository = new SectionRepository();

        sectionRepository.saveAll(initializedSections);
        return sectionRepository;
    }
}

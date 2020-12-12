package subway.section.infra;

import static subway.line.infra.LineRepositoryFactory.*;
import static subway.station.infra.StationRepositoryFactory.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.section.domain.Section;
import subway.section.domain.SectionRepository;

public class SectionRepositoryFactory {
    public static final Section 이호선_교대역_1 = new Section(이호선, 교대역, 1);
    public static final Section 이호선_강남역_2 = new Section(이호선, 강남역, 2);
    public static final Section 이호선_역삼역_3 = new Section(이호선, 역삼역, 3);
    public static final Section 삼호선_교대역_1 = new Section(삼호선, 교대역, 1);
    public static final Section 삼호선_남부터미널역_2 = new Section(삼호선, 남부터미널역, 2);
    public static final Section 삼호선_양재역_3 = new Section(삼호선, 양재역, 3);
    public static final Section 삼호선_매봉역_4 = new Section(삼호선, 매봉역, 4);
    public static final Section 신분당선_강남역_1 = new Section(신분당선, 강남역, 1);
    public static final Section 신분당선_양재역_2 = new Section(신분당선, 양재역, 2);
    public static final Section 신분당선_양재시민의숲역_3 = new Section(신분당선, 양재시민의숲역, 3);
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

package subway.infra.factory;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import subway.domain.SectionRepository;

class SectionRepositoryFactoryTest {
    @DisplayName("초기 설정된 SectionRepository를 반환한다")
    @Test
    void generate() {
        // When
        final SectionRepository sectionRepository = SectionRepositoryFactory.generate();

        // Then
        assertThat(sectionRepository)
                .extracting(SectionRepository::findAll)
                .asList()
                .hasSize(10)
        ;
    }
}

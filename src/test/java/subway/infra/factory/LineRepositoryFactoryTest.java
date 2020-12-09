package subway.infra.factory;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import subway.domain.LineRepository;

class LineRepositoryFactoryTest {
    @DisplayName("초기 설정된 LineRepository를 반환한다")
    @Test
    void generate() {
        // When
        final LineRepository lineRepository = LineRepositoryFactory.generate();

        // Then
        assertThat(lineRepository)
                .extracting(LineRepository::findAll)
                .asList()
                .hasSize(3)
        ;
    }
}

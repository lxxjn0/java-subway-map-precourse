package subway.station.infra;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import subway.station.domain.StationRepository;

class StationRepositoryFactoryTest {
    @DisplayName("초기 설정된 StationRepository를 반환한다")
    @Test
    void generate() {
        // When
        final StationRepository stationRepository = StationRepositoryFactory.generate();

        // Then
        assertThat(stationRepository)
                .extracting(StationRepository::findAll)
                .asList()
                .hasSize(7)
        ;
    }
}

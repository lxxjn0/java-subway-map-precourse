package subway.infra.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationRepositoryFactory {
    static final Station 교대역 = new Station("교대역");
    static final Station 강남역 = new Station("강남역");
    static final Station 역삼역 = new Station("역삼역");
    static final Station 남부터미널역 = new Station("남부터미널역");
    static final Station 양재역 = new Station("양재역");
    static final Station 양재시민의숲역 = new Station("양재시민의숲역");
    static final Station 매봉역 = new Station("매봉역");
    private static final List<Station> initializedStations = new ArrayList<>();

    static {
        final List<Station> stations = Arrays.asList(
                교대역,
                강남역,
                역삼역,
                남부터미널역,
                양재역,
                양재시민의숲역,
                매봉역
        );
        initializedStations.addAll(stations);
    }

    private StationRepositoryFactory() {
    }

    public static StationRepository generate() {
        final StationRepository stationRepository = new StationRepository();

        stationRepository.saveAll(initializedStations);
        return stationRepository;
    }
}

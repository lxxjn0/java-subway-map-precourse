package subway.station.application;

import java.util.List;
import java.util.stream.Collectors;

import subway.station.domain.Station;

public class StationResponse {
    private String name;

    private StationResponse(final String name) {
        this.name = name;
    }

    public static StationResponse from(final Station station) {
        return new StationResponse(station.getName());
    }

    public static List<StationResponse> toList(final List<Station> stations) {
        return stations.stream()
                .map(StationResponse::from)
                .collect(Collectors.toList())
                ;
    }

    public String getName() {
        return name;
    }
}

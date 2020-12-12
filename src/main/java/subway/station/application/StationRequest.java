package subway.station.application;

import subway.common.application.AbstractRequest;
import subway.station.domain.Station;

public class StationRequest extends AbstractRequest<Station> {
    private String name;

    public StationRequest(final String name) {
        this.name = name;
    }

    @Override
    public Station toEntity() {
        return new Station(name);
    }

    public String getName() {
        return name;
    }
}

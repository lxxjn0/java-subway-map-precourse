package subway.station.application;

import subway.common.application.AbstractRequest;
import subway.station.domain.Station;

public class StationDeleteRequest extends AbstractRequest<Station> {
    private String name;

    public StationDeleteRequest(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

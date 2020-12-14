package subway.station.application;

import static subway.common.domain.Method.*;
import static subway.station.presentation.StationController.*;

import subway.common.application.AbstractRequest;
import subway.common.domain.Method;
import subway.station.domain.Station;

public class StationRequest extends AbstractRequest<Station> {
    private String name;

    private StationRequest(
            final String uri,
            final Method method,
            final String name
    ) {
        super(uri, method);
        this.name = name;
    }

    public static StationRequest of(final String name) {
        return new StationRequest(STATION_URI, CREATE, name);
    }

    @Override
    public Station toEntity() {
        return new Station(name);
    }

    public String getName() {
        return name;
    }
}

package subway.station.application;

import static subway.common.domain.RequestMethod.*;
import static subway.station.presentation.StationController.*;

import subway.common.application.AbstractRequest;
import subway.common.domain.RequestMethod;
import subway.station.domain.Station;

public class StationDeleteRequest extends AbstractRequest<Station> {
    private String name;

    private StationDeleteRequest(
            final String uri,
            final RequestMethod requestMethod,
            final String name
    ) {
        super(uri, requestMethod);
        this.name = name;
    }

    public static StationDeleteRequest of(final String name) {
        return new StationDeleteRequest(STATION_URI, DELETE, name);
    }

    @Override
    public Station toEntity() {
        return new Station(name);
    }

    public String getName() {
        return name;
    }
}

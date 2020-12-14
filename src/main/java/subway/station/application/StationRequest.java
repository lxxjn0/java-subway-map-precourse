package subway.station.application;

import subway.common.application.AbstractRequest;
import subway.common.domain.RequestMethod;
import subway.station.domain.Station;

public class StationRequest extends AbstractRequest<Station> {
    private String name;

    private StationRequest(
            final String uri,
            final RequestMethod requestMethod,
            final String name
    ) {
        super(uri, requestMethod);
        this.name = name;
    }

    public static StationRequest of(final String name) {
        return new StationRequest("/stations", RequestMethod.CREATE, name);
    }

    @Override
    public Station toEntity() {
        return new Station(name);
    }

    public String getName() {
        return name;
    }
}

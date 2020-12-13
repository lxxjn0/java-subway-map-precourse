package subway.station.application;

import subway.common.Method;
import subway.common.application.AbstractRequest;
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
        return new StationRequest("/stations", Method.CREATE, name);
    }

    @Override
    public Station toEntity() {
        return new Station(name);
    }

    public String getName() {
        return name;
    }
}

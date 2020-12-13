package subway.section.application;

import subway.common.Method;
import subway.common.application.AbstractRequest;
import subway.section.domain.Section;

public class SectionDeleteRequest extends AbstractRequest<Section> {
    private String lineName;
    private String stationName;

    private SectionDeleteRequest(
            final String uri,
            final Method method,
            final String lineName,
            final String stationName
    ) {
        super(uri, method);
        this.lineName = lineName;
        this.stationName = stationName;
    }

    public static SectionDeleteRequest of(final String lineName, final String stationName) {
        return new SectionDeleteRequest("/sections", Method.DELETE, lineName, stationName);
    }

    @Override
    public Section toEntity() {
        return Section.of(lineName, stationName, Integer.MAX_VALUE);
    }

    public String getLineName() {
        return lineName;
    }

    public String getStationName() {
        return stationName;
    }
}

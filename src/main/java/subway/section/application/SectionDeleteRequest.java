package subway.section.application;

import subway.common.application.AbstractRequest;
import subway.section.domain.Section;

public class SectionDeleteRequest extends AbstractRequest<Section> {
    private String lineName;
    private String stationName;

    public SectionDeleteRequest(final String lineName, final String stationName) {
        this.lineName = lineName;
        this.stationName = stationName;
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

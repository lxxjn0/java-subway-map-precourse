package subway.section.application;

import subway.common.application.AbstractRequest;
import subway.section.domain.Section;

public class SectionRequest extends AbstractRequest<Section> {
    private int sequence;
    private String lineName;
    private String stationName;

    public SectionRequest(final int sequence, final String lineName, final String stationName) {
        this.sequence = sequence;
        this.lineName = lineName;
        this.stationName = stationName;
    }

    @Override
    public Section toEntity() {
        return Section.of(lineName, stationName, sequence);
    }

    public int getSequence() {
        return sequence;
    }

    public String getLineName() {
        return lineName;
    }

    public String getStationName() {
        return stationName;
    }
}

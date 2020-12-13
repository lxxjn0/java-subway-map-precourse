package subway.section.application;

import subway.common.application.AbstractRequest;
import subway.common.domain.Method;
import subway.section.domain.Section;

public class SectionRequest extends AbstractRequest<Section> {
    private int sequence;
    private String lineName;
    private String stationName;

    private SectionRequest(
            final String uri,
            final Method method,
            final String lineName,
            final String stationName,
            final int sequence
    ) {
        super(uri, method);
        this.sequence = sequence;
        this.lineName = lineName;
        this.stationName = stationName;
    }

    public static SectionRequest of(
            final int sequence,
            final String lineName,
            final String stationName
    ) {
        return new SectionRequest("/sections", Method.CREATE, lineName, stationName, sequence);
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

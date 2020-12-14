package subway.section.application;

import static subway.common.domain.RequestMethod.*;
import static subway.section.presentation.SectionController.*;

import subway.common.application.AbstractRequest;
import subway.common.domain.RequestMethod;
import subway.section.domain.Section;

public class SectionRequest extends AbstractRequest<Section> {
    private int sequence;
    private String lineName;
    private String stationName;

    private SectionRequest(
            final String uri,
            final RequestMethod requestMethod,
            final String lineName,
            final String stationName,
            final int sequence
    ) {
        super(uri, requestMethod);
        this.sequence = sequence;
        this.lineName = lineName;
        this.stationName = stationName;
    }

    public static SectionRequest of(
            final int sequence,
            final String lineName,
            final String stationName
    ) {
        return new SectionRequest(SECTION_URI, CREATE, lineName, stationName,
                sequence);
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

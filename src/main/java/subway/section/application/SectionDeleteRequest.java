package subway.section.application;

import static subway.common.domain.Method.*;
import static subway.section.presentation.SectionController.*;

import subway.common.application.AbstractRequest;
import subway.common.domain.Method;
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
        return new SectionDeleteRequest(SECTION_URI, DELETE, lineName, stationName);
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

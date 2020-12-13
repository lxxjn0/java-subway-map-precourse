package subway.section.application;

import java.util.List;
import java.util.stream.Collectors;

import subway.line.application.LineResponse;
import subway.section.domain.Section;
import subway.station.application.StationResponse;

public class SectionResponse {
    private LineResponse lineResponse;
    private StationResponse stationResponse;
    private int sequence;

    private SectionResponse(final LineResponse lineResponse, final StationResponse stationResponse,
            final int sequence) {
        this.lineResponse = lineResponse;
        this.stationResponse = stationResponse;
        this.sequence = sequence;
    }

    public static SectionResponse from(final Section section) {
        final LineResponse lineResponse = LineResponse.from(section.getLine());
        final StationResponse stationResponse = StationResponse.from(section.getStation());

        return new SectionResponse(lineResponse, stationResponse, section.getSequence());
    }

    public static List<SectionResponse> toList(final List<Section> sections) {
        return sections.stream()
                .map(SectionResponse::from)
                .collect(Collectors.toList())
                ;
    }

    public LineResponse getLineResponse() {
        return lineResponse;
    }

    public StationResponse getStationResponse() {
        return stationResponse;
    }

    public int getSequence() {
        return sequence;
    }
}

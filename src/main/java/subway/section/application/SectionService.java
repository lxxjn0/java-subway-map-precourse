package subway.section.application;

import static subway.section.domain.Section.*;
import static subway.section.exception.IllegalSectionException.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import subway.line.application.LineResponse;
import subway.line.domain.Line;
import subway.line.domain.LineRepository;
import subway.line.exception.IllegalLineException;
import subway.section.domain.Section;
import subway.section.domain.SectionRepository;
import subway.section.exception.IllegalSectionException;
import subway.station.domain.StationRepository;
import subway.station.exception.IllegalStationException;

public class SectionService {
    private final StationRepository stationRepository;
    private final LineRepository lineRepository;
    private final SectionRepository sectionRepository;

    public SectionService(final StationRepository stationRepository,
            final LineRepository lineRepository, final SectionRepository sectionRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
        this.sectionRepository = sectionRepository;
    }

    public void create(final SectionRequest request) {
        validateLineAndStation(request.getLineName(), request.getStationName());

        final Section section = request.toEntity();
        final List<Section> persists = sectionRepository.findAllByLineAndSequenceGreaterThanEqual(
                section.getLine(), section.getSequence());

        final long availableSequence = sectionRepository.countAllByLine(section.getLine()) + 1;

        if (availableSequence < section.getSequence()) {
            throw new IllegalSectionException(INVALID_SEQUENCE);
        }

        for (final Section persist : persists) {
            persist.increaseSequence();
        }

        sectionRepository.save(section);
    }

    public Map<LineResponse, List<SectionResponse>> showAllByEachLine() {
        final List<Line> lines = lineRepository.findAll();

        return lines.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(
                                LineResponse::from,
                                line -> SectionResponse.toList(
                                        sectionRepository.findAllByLineOrderBySequence(line)
                                )),
                        TreeMap::new
                        )
                )
                ;
    }

    public SectionDeleteResponse removeByLineAndStation(final SectionDeleteRequest request) {
        validateLineAndStation(request.getLineName(), request.getStationName());

        final Section section = request.toEntity();
        final Section persist = sectionRepository.findByLineAndStation(section.getLine(),
                section.getStation());
        final List<Section> persists = sectionRepository.findAllByLineAndSequenceGreaterThanEqual(
                persist.getLine(), persist.getSequence());

        if (persists.size() <= LOWER_BOUND_STATION_SIZE) {
            throw new IllegalSectionException(CONSTRAINT_STATION_SIZE);
        }

        for (final Section value : persists) {
            value.decreaseSequence();
        }

        return new SectionDeleteResponse(sectionRepository.deleteByLineAndStation(persist.getLine(),
                persist.getStation()));
    }

    private void validateLineAndStation(final String lineName, final String stationName) {
        if (!lineRepository.existsByName(lineName)) {
            throw new IllegalLineException(IllegalLineException.NOT_EXISTS);
        }

        if (!stationRepository.existsByName(stationName)) {
            throw new IllegalStationException(IllegalStationException.NOT_EXISTS);
        }
    }
}

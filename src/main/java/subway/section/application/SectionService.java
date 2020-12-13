package subway.section.application;

import static subway.section.domain.Section.*;
import static subway.section.exception.IllegalSectionException.*;
import static subway.station.exception.IllegalStationException.*;

import java.util.List;

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

        final List<Section> sections = sectionRepository.findAllByLineAndSequenceGreaterThanEqual(
                section.getLine(), section.getSequence());

        if (sections.size() < section.getSequence()) {
            throw new IllegalSectionException(INVALID_SEQUENCE);
        }

        for (final Section value : sections) {
            value.increaseSequence();
        }

        sectionRepository.updateAll(sections);
        sectionRepository.save(section);
    }

    public boolean removeByLineAndStation(final SectionDeleteRequest request) {
        validateLineAndStation(request.getLineName(), request.getStationName());

        final Section section = request.toEntity();

        final Section savedSection = sectionRepository.findByLineAndStation(section.getLine(),
                section.getStation());

        if (sectionRepository.countByLine(savedSection.getLine()) <= LOWER_BOUND_STATION_SIZE) {
            throw new IllegalSectionException(CONSTRAINT_STATION_SIZE);
        }

        final List<Section> sections = sectionRepository.findAllByLineAndSequenceGreaterThanEqual(
                savedSection.getLine(), savedSection.getSequence());

        for (final Section value : sections) {
            value.decreaseSequence();
        }

        sectionRepository.updateAll(sections);
        return sectionRepository.deleteByLineAndStation(savedSection.getLine(),
                savedSection.getStation());
    }

    private void validateLineAndStation(final String lineName, final String stationName) {
        if (!lineRepository.existsByName(lineName)) {
            throw new IllegalLineException(IllegalLineException.NOT_EXISTS);
        }

        if (!stationRepository.existsByName(stationName)) {
            throw new IllegalStationException(NOT_EXISTS);
        }
    }
}

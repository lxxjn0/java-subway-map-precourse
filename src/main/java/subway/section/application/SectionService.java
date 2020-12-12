package subway.section.application;

import static subway.section.exception.IllegalSectionException.*;
import static subway.station.exception.IllegalStationException.*;

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
        if (!stationRepository.existsByName(request.getStationName())) {
            throw new IllegalStationException(NOT_EXISTS);
        }

        if (!lineRepository.existsByName(request.getLineName())) {
            throw new IllegalLineException(IllegalLineException.NOT_EXISTS);
        }

        final Section section = request.toEntity();

        if (sectionRepository.countByLine(section.getLine()) < section.getSequence()) {
            throw new IllegalSectionException(INVALID_SEQUENCE);
        }
        sectionRepository.save(section);
    }
}

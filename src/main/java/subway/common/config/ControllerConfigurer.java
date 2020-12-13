package subway.common.config;

import static subway.common.config.ControllerMapping.*;

import java.util.HashMap;
import java.util.Map;

import subway.common.presentation.Controller;
import subway.line.application.LineService;
import subway.line.domain.LineRepository;
import subway.line.infra.LineRepositoryFactory;
import subway.line.presentation.LineController;
import subway.section.application.SectionService;
import subway.section.domain.SectionRepository;
import subway.section.infra.SectionRepositoryFactory;
import subway.section.presentation.SectionController;
import subway.station.application.StationDeleteService;
import subway.station.application.StationService;
import subway.station.domain.StationRepository;
import subway.station.infra.StationRepositoryFactory;
import subway.station.presentation.StationController;

public class ControllerConfigurer {
    private ControllerConfigurer() {
    }

    public static Map<ControllerMapping, Controller> generate() {
        final Map<ControllerMapping, Controller> controllers = new HashMap<>();

        final StationRepository stationRepository = StationRepositoryFactory.generate();
        final LineRepository lineRepository = LineRepositoryFactory.generate();
        final SectionRepository sectionRepository = SectionRepositoryFactory.generate();

        controllers.put(STATION_CONTROLLER,
                generateStationController(stationRepository, sectionRepository));
        controllers.put(LINE_CONTROLLER,
                generateLineController(stationRepository, lineRepository, sectionRepository));
        controllers.put(SECTION_CONTROLLER,
                generateSectionController(stationRepository, lineRepository, sectionRepository));

        return controllers;
    }

    private static StationController generateStationController(
            final StationRepository stationRepository,
            final SectionRepository sectionRepository
    ) {
        final StationService stationService = new StationService(stationRepository);
        final StationDeleteService stationDeleteService = new StationDeleteService(
                stationRepository, sectionRepository);

        return new StationController(stationService, stationDeleteService);
    }

    private static LineController generateLineController(
            final StationRepository stationRepository,
            final LineRepository lineRepository,
            final SectionRepository sectionRepository
    ) {
        final LineService lineService = new LineService(stationRepository, lineRepository,
                sectionRepository);

        return new LineController(lineService);
    }

    private static SectionController generateSectionController(
            final StationRepository stationRepository,
            final LineRepository lineRepository,
            final SectionRepository sectionRepository
    ) {
        final SectionService sectionService = new SectionService(stationRepository, lineRepository,
                sectionRepository);

        return new SectionController(sectionService);
    }
}

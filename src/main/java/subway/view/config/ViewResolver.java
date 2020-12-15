package subway.view.config;

import static subway.view.config.ViewMapping.*;

import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

import subway.common.domain.Category;
import subway.common.domain.Method;
import subway.view.line.LineCreateView;
import subway.view.line.LineDeleteView;
import subway.view.line.LineReadView;
import subway.view.section.SectionCreateView;
import subway.view.section.SectionDeleteView;
import subway.view.section.SectionReadView;
import subway.view.station.StationCreateView;
import subway.view.station.StationDeleteView;
import subway.view.station.StationReadView;

public class ViewResolver {
    private final Map<ViewMapping, View<?>> views;

    private ViewResolver(final Map<ViewMapping, View<?>> views) {
        this.views = views;
    }

    public static ViewResolver from(final Scanner scanner) {
        final Map<ViewMapping, View<?>> views = new EnumMap<>(ViewMapping.class);

        views.put(STATION_CREATE, new StationCreateView(scanner));
        views.put(STATION_DELETE, new StationDeleteView(scanner));
        views.put(STATION_READ, new StationReadView(scanner));

        views.put(LINE_CREATE, new LineCreateView(scanner));
        views.put(LINE_DELETE, new LineDeleteView(scanner));
        views.put(LINE_READ, new LineReadView(scanner));

        views.put(SECTION_CREATE, new SectionCreateView(scanner));
        views.put(SECTION_DELETE, new SectionDeleteView(scanner));
        views.put(SECTION_READ, new SectionReadView(scanner));

        return new ViewResolver(views);
    }

    public View<?> resolve(final Category category, final Method method) {
        return views.get(ViewMapping.of(category, method));
    }
}

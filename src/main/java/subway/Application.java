package subway;

import static subway.common.domain.Method.*;
import static subway.view.config.ViewMessageFixture.*;

import java.util.Scanner;

import subway.common.application.AbstractRequest;
import subway.common.domain.Category;
import subway.common.domain.Method;
import subway.common.presentation.Controller;
import subway.common.presentation.ControllerHandler;
import subway.view.MainScreenView;
import subway.view.config.View;
import subway.view.config.ViewResolver;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final ViewResolver viewResolver = ViewResolver.from(scanner);
        final MainScreenView screenView = new MainScreenView(scanner);

        while (true) {
            screenView.renderMainCategory();
            final Category category = screenView.receiveCategory();

            if (category.isTerminate()) {
                return;
            }
            resolveByController(viewResolver, screenView, category);
        }
    }

    private static void resolveByController(
            final ViewResolver viewResolver,
            final MainScreenView screenView,
            final Category category
    ) {
        while (true) {
            final Method method = receiveMethod(screenView, category);
            if (method.isNothing()) {
                return;
            }

            try {
                final View<?> view = viewResolver.resolve(category, method);
                final AbstractRequest<?> request = view.getRequest();
                final Controller controller = ControllerHandler.getController(request);
                view.renderResponse(controller.doService(request));
                return;
            } catch (IllegalArgumentException e) {
                System.out.printf(ERROR_FORMAT, e.getMessage());
            }
        }
    }

    private static Method receiveMethod(final MainScreenView screenView, final Category category) {
        if (category.isMap()) {
            return READ;
        }

        screenView.renderCategoryFeature(category);
        return screenView.receiveMethod(category);
    }
}

package subway.view;

import static subway.common.domain.Method.*;
import static subway.view.config.ViewMessageFixture.*;

import java.util.Map;
import java.util.Scanner;

import subway.common.domain.Category;
import subway.common.domain.Command;
import subway.common.domain.Method;

public class MainScreenView {
    private final Scanner scanner;

    public MainScreenView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public void renderMainCategory() {
        System.out.println(MAIN_SCREEN_MESSAGE);
        System.out.println(STATION_CATEGORY_MESSAGE);
        System.out.println(LINE_CATEGORY_MESSAGE);
        System.out.println(SECTION_CATEGORY_MESSAGE);
        System.out.println(MAP_CATEGORY_MESSAGE);
        System.out.println(TERMINATE_CATEGORY_MESSAGE);
        System.out.println();
    }

    public void renderCategoryFeature(final Category category) {
        System.out.printf(MANAGE_SCREEN_FORMAT, category.getName());
        for (Map.Entry<Command, String> entry : category.receiveMethodInfo().entrySet()) {
            final String commandNumber = entry.getKey().getInput();
            final String methodName = entry.getValue();
            System.out.printf(FEATURE_FORMAT, commandNumber, category.getName(), methodName);
        }
        System.out.println(GO_BACK_MESSAGE);
        System.out.println();
    }

    public Category receiveCategory() {
        while (true) {
            try {
                System.out.println(SELECT_FUNCTION_MESSAGE);
                final Command command = Command.from(scanner.nextLine());
                System.out.println();

                return Category.of(command);
            } catch (IllegalArgumentException e) {
                System.out.printf(ERROR_FORMAT, e.getMessage());
            }
        }
    }

    public Method receiveMethod(final Category category) {
        while (true) {
            try {
                System.out.println(SELECT_FUNCTION_MESSAGE);
                final Command command = Command.from(scanner.nextLine());
                System.out.println();

                if (command.isBack()) {
                    return NOTHING;
                }

                category.validate(command);
                return Method.from(command);
            } catch (IllegalArgumentException e) {
                System.out.printf(ERROR_FORMAT, e.getMessage());
            }
        }
    }
}

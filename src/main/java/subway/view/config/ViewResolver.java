package subway.view.config;

import static subway.common.domain.Method.*;

import java.util.Map;
import java.util.Scanner;

import subway.common.domain.Category;
import subway.common.domain.Command;
import subway.common.domain.Method;

public class ViewResolver {
    private final Map<ViewMapping, View<?, ?>> views;
    private final Scanner scanner;

    private ViewResolver(final Map<ViewMapping, View<?, ?>> views, final Scanner scanner) {
        this.views = views;
        this.scanner = scanner;
    }

    public static ViewResolver from(final Scanner scanner) {
        return new ViewResolver(ViewFactory.generate(scanner), scanner);
    }

    public View<?, ?> resolve() {
        while (true) {
            renderMainCategory();
            final Category category = receiveCategory();

            if (category.hasEmptyMethods()) {
                return views.get(ViewMapping.fromEmptyMethod(category));
            }

            renderSelectedCategory(category);
            final Method method = receiveMethod(category);

            if (!method.isNothing()) {
                return views.get(ViewMapping.of(category, method));
            }
        }

    }

    private Category receiveCategory() {
        while (true) {
            try {
                System.out.println("## 원하는 기능을 선택하세요.");
                final Command command = Command.from(scanner.nextLine());
                System.out.println();

                return Category.of(command);
            } catch (IllegalArgumentException e) {
                System.out.printf("[ERROR] %s%n", e.getMessage());
                System.out.println();
            }
        }
    }

    private void renderMainCategory() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        System.out.println();
    }

    private Method receiveMethod(final Category category) {
        while (true) {
            try {
                System.out.println("## 원하는 기능을 선택하세요.");
                final Command command = Command.from(scanner.nextLine());
                System.out.println();

                if (command.isBack()) {
                    return NOTHING;
                }
                category.validate(command);
                return Method.from(command);
            } catch (IllegalArgumentException e) {
                System.out.printf("[ERROR] %s%n", e.getMessage());
                System.out.println();
            }
        }
    }

    private void renderSelectedCategory(final Category category) {
        System.out.printf("## %s 관리 화면%n", category.getName());
        for (Map.Entry<Command, String> entry : category.receiveMethodInfo().entrySet()) {
            final String commandNumber = entry.getKey().getInput();
            final String methodName = entry.getValue();
            System.out.printf("%s. %s %s", commandNumber, category.getName(), methodName);
        }
        System.out.println("B. 돌아가기");
        System.out.println();
    }
}

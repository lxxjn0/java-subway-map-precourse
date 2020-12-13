package subway.common;

public enum Method {
    CREATE("등록"),
    READ("조회"),
    DELETE("삭제");

    final String name;

    Method(final String name) {
        this.name = name;
    }
}

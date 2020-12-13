package subway.line.application;

public class LineDeleteResponse {
    private boolean isDeleted;

    public LineDeleteResponse(final boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isDeleted() {
        return isDeleted;
    }
}

package subway.section.application;

public class SectionDeleteResponse {
    private boolean isDeleted;

    public SectionDeleteResponse(final boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isDeleted() {
        return isDeleted;
    }
}

package subway.station.application;

public class StationDeleteResponse {
    private boolean isDeleted;

    public StationDeleteResponse(final boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isDeleted() {
        return isDeleted;
    }
}

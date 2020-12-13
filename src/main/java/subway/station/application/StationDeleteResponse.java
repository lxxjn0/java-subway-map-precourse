package subway.station.application;

public class StationDeleteResponse {
    private boolean isDelete;

    public StationDeleteResponse(final boolean isDelete) {
        this.isDelete = isDelete;
    }

    public boolean isDelete() {
        return isDelete;
    }
}

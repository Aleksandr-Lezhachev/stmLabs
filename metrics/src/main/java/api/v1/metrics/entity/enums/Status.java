package api.v1.metrics.entity.enums;

public enum Status {
    UP("UP"),
    DOWN("DOWN"),
    OVERLOADED("OVERLOADED"),
    NOT_RESPONDING("NOT_RESPONDING");
    private String status;

    Status(String envStatus) {
        this.status = envStatus;
    }

    public String getStatus() {
        return status;
    }
}

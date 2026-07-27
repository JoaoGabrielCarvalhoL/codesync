package br.com.codesync.model.enumerations;

public enum MilestoneStatus {

    PLANNED(1, "PLANNED"),
    IN_PROGRESS(2, "IN_PROGRESS"),
    COMPLETED(3, "COMPLETED"),
    DELAYED(4, "DELAYED"),
    CANCELLED(5,"CANCELLED");

    private final Integer code;
    private final String description;

    MilestoneStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static MilestoneStatus fromCode(Integer code) {
        for (MilestoneStatus status : MilestoneStatus.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid Sprint Status Code: " + code);
    }
}

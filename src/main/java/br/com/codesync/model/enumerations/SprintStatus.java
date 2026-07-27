package br.com.codesync.model.enumerations;

public enum SprintStatus {
    PLANNED(1, "PLANNED"),
    ACTIVE(2, "ACTIVE"),
    COMPLETED(3, "COMPLETED"),
    CANCELLED(4, "CANCELLED");

    private final Integer code;
    private final String description;

    SprintStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static SprintStatus fromCode(Integer code) {
        for (SprintStatus status : SprintStatus.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid Sprint Status Code: " + code);
    }
}

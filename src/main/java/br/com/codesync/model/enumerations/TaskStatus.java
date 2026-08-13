package br.com.codesync.model.enumerations;

public enum TaskStatus {

    BACKLOG(1,"BACKLOG"),
    OPEN(2, "OPEN"),
    IN_PROGRESS(3,"IN_PROGRESS"),
    IN_REVIEW(4, "IN_REVIEW"),
    BLOCKED(5, "BLOCKED"),
    WAITING_CLIENT_APPROVAL(6, "WAITING_CLIENT_APPROVAL"),
    DONE(7, "DONE"),
    CANCELLED(8, "CANCELLED");

    private final Integer code;
    private final String description;

    TaskStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static TaskStatus fromCode(Integer code) {
        for (TaskStatus status : TaskStatus.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid TaskStatus code: " + code);

    }
}

package br.com.codesync.model.enumerations;

public enum TaskPriority {

    LOW(1, "LOW"),
    MEDIUM(2, "MEDIUM"),
    HIGH(3, "HIGH"),
    URGENT(4, "CRITICAL");

    private final Integer code;
    private final String description;

    TaskPriority(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static TaskPriority fromCode(Integer code) {
        for (TaskPriority taskPriority : TaskPriority.values()) {
            if (taskPriority.getCode().equals(code)) {
                return taskPriority;
            }
        }
        throw new IllegalArgumentException("Invalid TaskPriority code: " + code);
    }
}

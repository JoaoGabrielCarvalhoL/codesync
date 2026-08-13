package br.com.codesync.model.enumerations;

public enum TaskType {

    FEATURE(1, "FEATURE"),
    HOTFIX(2, "HOTFIX"),
    MAINTENANCE(3, "MAINTENANCE"),
    DOCUMENTATION(4, "DOCUMENTATION"),
    INTEGRATION(5, "INTEGRATION");

    private final Integer code;
    private final String description;

    TaskType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static TaskType fromCode(Integer code) {
        for (TaskType taskType : TaskType.values()) {
            if (taskType.code.equals(code)) {
                return taskType;
            }
        }
        throw new IllegalArgumentException("Invalid TaskType code: " + code);
    }

}

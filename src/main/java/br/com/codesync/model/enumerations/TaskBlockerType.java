package br.com.codesync.model.enumerations;

public enum TaskBlockerType {

    CLIENT_DEPENDENCY(1, "CLIENT_DEPENDENCY"),
    CONTRACT_PENDING(2, "CONTRACT_PENDING"),
    ENVIRONMENT_ISSUE(3, "ENVIRONMENT_ISSUE"),
    TECHNICAL_SPIKE(4, "TECHNICAL_SPIKE"),
    INTERNAL_DEPENDENCY(5, "INTERNAL_DEPENDENCY");

    private final Integer code;
    private final String description;

    TaskBlockerType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static TaskBlockerType fromCode(Integer code) {
        for (TaskBlockerType taskBlockerType : TaskBlockerType.values()) {
            if (taskBlockerType.getCode().equals(code)) {
                return taskBlockerType;
            }
        }
        throw new IllegalArgumentException("Invalid task blocker type: " + code);
    }
}

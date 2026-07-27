package br.com.codesync.model.enumerations;

public enum RevocationStatus {

    PENDING(1, "PENDING"),
    REVOKED(2, "REVOKED"),
    NOT_APPLICABLE(3, "NOT_APPLICABLE");

    private final Integer code;
    private final String description;

    RevocationStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static RevocationStatus fromCode(Integer code) {
        for (RevocationStatus status : RevocationStatus.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid RevocationStatus code: " + code);
    }
}

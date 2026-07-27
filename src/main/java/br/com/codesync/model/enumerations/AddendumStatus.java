package br.com.codesync.model.enumerations;

public enum AddendumStatus {
    DRAFT(1, "DRAFT"),
    PENDING_APPROVAL(2, "PENDING_APPROVAL"),
    APPROVED(3, "APPROVED"),
    REJECTED(4, "REJECTED"),
    CANCELLED(5, "CANCELLED");

    private final Integer code;
    private final String description;

    AddendumStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static AddendumStatus fromCode(Integer code) {
        for (AddendumStatus status : AddendumStatus.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid AddendumStatus code: " + code);
    }
}

package br.com.codesync.model.enumerations;

public enum ApprovalStatus {

    PENDING(1, "PENDING"),
    APPROVED(2, "APPROVED"),
    REJECTED(3, "REJECTED"),
    NONE(4, "NONE");

    private Integer code;
    private String description;

    ApprovalStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ApprovalStatus fromCode(Integer code) {
        for (ApprovalStatus approvalStatus : ApprovalStatus.values()) {
            if (approvalStatus.getCode().equals(code)) {
                return approvalStatus;
            }
        }
        throw new IllegalArgumentException("Invalid approval status: " + code);
    }

}

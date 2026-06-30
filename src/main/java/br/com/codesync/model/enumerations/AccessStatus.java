package br.com.codesync.model.enumerations;

public enum AccessStatus {

    ACTIVE(1, "User access is active"),
    LOGGED_OUT(2, "User logged out successfully"),
    REVOKED(3, "Access was revoked by the system or an administrator"),
    EXPIRED(4, "Access expired due to session timeout");

    private final Integer id;
    private final String description;

    AccessStatus(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public static AccessStatus fromId(Integer id) {
        for (AccessStatus status : AccessStatus.values()) {
            if (status.getId().equals(id)) {
                return status;
            }
        }
        throw new IllegalArgumentException("AccessStatus not found. Id: " + id);
    }
}

package br.com.codesync.model.enumerations;

public enum ProfessionalStatus {
    ACTIVE(1, "Active and Available"),
    ON_LEAVE(2, "On Leave / Vacation"),
    ON_PROJECT(3, "Fully Allocated on Project"),
    BLOCKED(4, "Blocked / Pending Action"),
    INACTIVE(5, "Inactive / Offboarded");

    private final Integer id;
    private final String description;

    ProfessionalStatus(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public static ProfessionalStatus fromId(Integer id) {
        for (ProfessionalStatus status : ProfessionalStatus.values()) {
            if (status.getId().equals(id)) {
                return status;
            }
        }
        throw new IllegalArgumentException("ProfessionalStatus not found. Id: " + id);
    }
}

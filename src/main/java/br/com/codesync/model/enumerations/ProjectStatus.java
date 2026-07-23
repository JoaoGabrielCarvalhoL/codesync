package br.com.codesync.model.enumerations;

public enum ProjectStatus {

    PLANNING(1, "In Planning / Discovery"),
    IN_PROGRESS(2, "In Progress / Active Development"),
    ON_HOLD(3, "On Hold / Paused"),
    COMPLETED(4, "Completed"),
    CANCELLED(5, "Cancelled");

    private final Integer id;
    private final String description;

    ProjectStatus(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public static ProjectStatus fromId(Integer id) {
        for (ProjectStatus status : ProjectStatus.values()) {
            if (status.getId().equals(id)) {
                return status;
            }
        }
        throw new IllegalArgumentException("ProjectStatus not found. Id: " + id);
    }
}

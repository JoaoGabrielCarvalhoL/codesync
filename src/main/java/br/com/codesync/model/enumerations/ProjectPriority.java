package br.com.codesync.model.enumerations;

public enum ProjectPriority {

    LOW(1, "Low Priority"),
    MEDIUM(2, "Medium Priority"),
    HIGH(3, "High Priority"),
    CRITICAL(4, "Critical / Immediate Attention Needed");

    private final Integer id;
    private final String description;

    ProjectPriority(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public static ProjectPriority fromId(Integer id) {
        for (ProjectPriority priority : ProjectPriority.values()) {
            if (priority.getId().equals(id)) {
                return priority;
            }
        }
        throw new IllegalArgumentException("ProjectPriority not found. Id: " + id);
    }
}

package br.com.codesync.model.enumerations;

public enum SeniorityLevel {

    INTERN(1, "Intern"),
    TRAINEE(2, "Trainee"),
    JUNIOR(3, "Junior Developer"),
    FULL(4, "Mid-Level / Full Developer"),
    SENIOR(5, "Senior Developer"),
    LEAD(6, "Tech Lead / Principal Engineer");

    private final Integer id;
    private final String description;

    SeniorityLevel(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public static SeniorityLevel fromId(Integer id) {
        for (SeniorityLevel level : SeniorityLevel.values()) {
            if (level.getId().equals(id)) {
                return level;
            }
        }
        throw new IllegalArgumentException("SeniorityLevel not found. Id: " + id);
    }
}

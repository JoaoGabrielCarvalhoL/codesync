package br.com.codesync.model.enumerations;

public enum ProficiencyLevel {

    BEGINNER(1, "Beginner / Learning"),
    INTERMEDIATE(2, "Intermediate / Autonomous"),
    ADVANCED(3, "Advanced / Fluent"),
    EXPERT(4, "Expert / Authority");

    private final Integer id;
    private final String description;

    ProficiencyLevel(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }

    public static ProficiencyLevel fromId(Integer id) {
        for (ProficiencyLevel level : ProficiencyLevel.values()) {
            if (level.getId().equals(id)) {
                return level;
            }
        }
        throw new IllegalArgumentException("SkillCategory not found. Id: " + id);
    }
}

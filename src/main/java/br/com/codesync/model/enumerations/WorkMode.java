package br.com.codesync.model.enumerations;

public enum WorkMode {
    REMOTE(1, "100% Remote Work"),
    ONSITE(2, "On-Site / Office Based"),
    HYBRID(3, "Hybrid Work Mode");

    private final Integer id;
    private final String description;

    WorkMode(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public static WorkMode fromId(Integer id) {
        for (WorkMode mode : WorkMode.values()) {
            if (mode.getId().equals(id)) {
                return mode;
            }
        }
        throw new IllegalArgumentException("WorkMode not found. Id: " + id);
    }
}

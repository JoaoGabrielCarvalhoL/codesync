package br.com.codesync.model.enumerations;

public enum ProjectRole {
    PROJECT_MANAGER(1, "Project Manager / Delivery Manager"),
    PRODUCT_OWNER(2, "Product Owner"),
    TECH_LEAD(3, "Tech Lead / Software Architect"),
    DEVELOPER(4, "Software Developer"),
    QA_ENGINEER(5, "QA / Test Engineer"),
    DESIGNER(6, "UI/UX Designer");

    private final Integer id;
    private final String description;

    ProjectRole(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public static ProjectRole fromId(Integer id) {
        for (ProjectRole role : ProjectRole.values()) {
            if (role.getId().equals(id)) {
                return role;
            }
        }
        throw new IllegalArgumentException("ProjectRole not found. Id: " + id);
    }
}

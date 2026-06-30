package br.com.codesync.model.enumerations;

public enum Role {

    ADMIN(1, "System Administrator"),
    MANAGER(2, "Project Manager"),
    USER(3, "Software Developer"),
    REVIEWER(4, ""),
    TESTER(5, "");

    private final Integer id;
    private final String description;

    Role(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public static Role getRole(Integer id) {
        for (Role role : Role.values()) {
            if (role.getId().equals(id)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Role Not Found. Id: " + id);
    }
}

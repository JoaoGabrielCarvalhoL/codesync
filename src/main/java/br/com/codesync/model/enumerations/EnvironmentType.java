package br.com.codesync.model.enumerations;

public enum EnvironmentType {

    DEVELOPMENT(1, "DEV", "Development Environment"),
    STAGING(2, "STG", "Staging/Homologation Environment"),
    PRODUCTION(3, "PRD", "Production Environment"),
    VPN(4, "VPN", "VPN Access & Network Profile"),
    SCM_REPOSITORY(5, "GIT", "Git Repository (GitLab, GitHub, Bitbucket)"),
    DOCUMENTATION(6, "DOC", "Documentation / Wiki (Confluence, Notion)");

    private final Integer id;
    private final String code;
    private final String description;

    EnvironmentType(Integer id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public Integer getId() { return this.id; }
    public String getCode() { return this.code; }
    public String getDescription() { return this.description; }

    public static EnvironmentType fromId(Integer id) {
        for (EnvironmentType environmentType : EnvironmentType.values()) {
            if (environmentType.getId().equals(id)) {
                return environmentType;
            }
        }
        throw new IllegalArgumentException("EnvironmentType not found. Id: " + id);
    }

    public static EnvironmentType fromCode(String code) {
        if (code == null) return null;
        for (EnvironmentType environmentType : EnvironmentType.values()) {
            if (environmentType.getCode().equalsIgnoreCase(code.trim())) {
                return environmentType;
            }
        }
        throw new IllegalArgumentException("EnvironmentType not found. Code: " + code);
    }
}

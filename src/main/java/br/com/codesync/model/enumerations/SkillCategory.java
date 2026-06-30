package br.com.codesync.model.enumerations;

public enum SkillCategory {

    LANGUAGE(1, "Programming Language"),
    FRAMEWORK(2, "Framework / Library"),
    MESSAGING(3, "Messaging / Event Streaming"),
    DATABASE(4, "Database / Storage"),
    DEVOPS(5, "DevOps / CI-CD"),
    CLOUD(6, "Cloud Providers / Infrastructure"),
    DATA_SCIENCE(7, "Data Science"),
    MACHINE_LEARNING(8, "Machine Learning / AI"),
    ARCHITECTURE(9, "Software Architecture"),
    SRE(10, "Site Reliability Engineering"),
    PRODUCT(11, "Product Management"),
    BUSINESS_ANALYSIS(12, "Business Analysis"),
    UX_UI(13, "UX / UI Design"),
    QA(14, "Quality Assurance / Testing"),
    AGILE_METHODOLOGY(15, "Agile Methodologies & Frameworks"),
    MANAGEMENT_LEADERSHIP(16, "Management & Team Leadership"),
    DATA_ANALYTICS(17, "Data Analytics & Business Intelligence");

    private final Integer id;
    private final String description;

    SkillCategory(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public static SkillCategory fromId(Integer id) {
        for (SkillCategory category : SkillCategory.values()) {
            if (category.getId().equals(id)) {
                return category;
            }
        }
        throw new IllegalArgumentException("SkillCategory not found. Id: " + id);
    }
}

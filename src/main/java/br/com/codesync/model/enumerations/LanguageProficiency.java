package br.com.codesync.model.enumerations;

public enum LanguageProficiency {

    ELEMENTARY(1, "Elementary / Basic"),
    LIMITED(2, "Limited Working Proficiency"),
    PROFESSIONAL(3, "Professional Working Proficiency"),
    FULL_PROFESSIONAL(4, "Full Professional / Fluent"),
    NATIVE_BILINGUAL(5, "Native or Bilingual Proficiency");

    private final Integer id;
    private final String description;

    LanguageProficiency(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public static LanguageProficiency fromId(Integer id) {
        for (LanguageProficiency proficiency : LanguageProficiency.values()) {
            if (proficiency.getId().equals(id)) {
                return proficiency;
            }
        }
        throw new IllegalArgumentException("LanguageProficiency not found. Id: " + id);
    }
}

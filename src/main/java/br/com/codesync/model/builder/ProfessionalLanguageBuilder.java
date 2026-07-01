package br.com.codesync.model.builder;

import br.com.codesync.model.entity.ProfessionalLanguage;
import br.com.codesync.model.entity.ProfessionalProfile;
import br.com.codesync.model.enumerations.LanguageProficiency;

import java.util.UUID;

public final class ProfessionalLanguageBuilder {

    private final ProfessionalLanguage professionalLanguage;

    private ProfessionalLanguageBuilder() {
        this.professionalLanguage = new ProfessionalLanguage();
    }

    public static ProfessionalLanguageBuilder builder() {
        return new ProfessionalLanguageBuilder();
    }

    public ProfessionalLanguageBuilder id(UUID id) {
        this.professionalLanguage.setId(id);
        return this;
    }

    public ProfessionalLanguageBuilder name(String name) {
        this.professionalLanguage.setName(name);
        return this;
    }

    public ProfessionalLanguageBuilder proficiencyLevel(LanguageProficiency proficiencyLevel) {
        this.professionalLanguage.setLanguageProficiency(proficiencyLevel);
        return this;
    }

    public ProfessionalLanguageBuilder professionalProfile(ProfessionalProfile professionalProfile) {
        this.professionalLanguage.setProfessionalProfile(professionalProfile);
        return this;
    }

    public ProfessionalLanguage build() {
        return this.professionalLanguage;
    }
}

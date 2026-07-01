package br.com.codesync.model.builder;

import br.com.codesync.model.entity.ProfessionalProfile;
import br.com.codesync.model.entity.ProfessionalSkill;
import br.com.codesync.model.entity.Skill;
import br.com.codesync.model.enumerations.ProficiencyLevel;

import java.util.UUID;

public final class ProfessionalSkillBuilder {

    private final ProfessionalSkill professionalSkill;

    public ProfessionalSkillBuilder() {
        this.professionalSkill = new ProfessionalSkill();
    }

    public static ProfessionalSkillBuilder builder() {
        return new ProfessionalSkillBuilder();
    }

    public ProfessionalSkillBuilder id(UUID id) {
        this.professionalSkill.setId(id);
        return this;
    }

    public ProfessionalSkillBuilder skill(Skill skill) {
        this.professionalSkill.setSkill(skill);
        return this;
    }

    public ProfessionalSkillBuilder proficiencyLevel(ProficiencyLevel proficiencyLevel) {
        this.professionalSkill.setProficiencyLevel(proficiencyLevel);
        return this;
    }

    public ProfessionalSkillBuilder professionalProfile(ProfessionalProfile professionalProfile) {
        this.professionalSkill.setProfessionalProfile(professionalProfile);
        return this;
    }

    public ProfessionalSkill build() {
        return this.professionalSkill;
    }
}

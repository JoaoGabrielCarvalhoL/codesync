package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Project;
import br.com.codesync.model.entity.ProjectRequiredSkill;
import br.com.codesync.model.entity.Skill;
import br.com.codesync.model.enumerations.ProficiencyLevel;

import java.util.UUID;

public final class ProjectRequiredSkillBuilder {

    private ProjectRequiredSkill projectRequiredSkill;

    private ProjectRequiredSkillBuilder() {
        this.projectRequiredSkill = new ProjectRequiredSkill();
    }

    public static ProjectRequiredSkillBuilder builder() {
        return new ProjectRequiredSkillBuilder();
    }

    public ProjectRequiredSkillBuilder id(UUID id) {
        this.projectRequiredSkill.setId(id);
        return this;
    }

    public ProjectRequiredSkillBuilder project(Project project) {
        this.projectRequiredSkill.setProject(project);
        return this;
    }

    public ProjectRequiredSkillBuilder skill(Skill skill) {
        this.projectRequiredSkill.setSkill(skill);
        return this;
    }

    public ProjectRequiredSkillBuilder proficiencyLevel(ProficiencyLevel proficiencyLevel) {
        this.projectRequiredSkill.setProficiencyLevel(proficiencyLevel);
        return this;
    }

    public ProjectRequiredSkill build() {
        ProjectRequiredSkill result = this.projectRequiredSkill;
        this.projectRequiredSkill = new ProjectRequiredSkill();
        return result;
    }

}

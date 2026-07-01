package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Skill;
import br.com.codesync.model.enumerations.SkillCategory;

import java.util.UUID;

public final class SkillBuilder {

    private final Skill skill;

    public SkillBuilder() {
        this.skill = new Skill();
    }

    public static SkillBuilder builder() {
        return new SkillBuilder();
    }

    public SkillBuilder id(UUID id) {
        this.skill.setId(id);
        return this;
    }

    public SkillBuilder name(String name) {
        this.skill.setName(name);
        return this;
    }

    public SkillBuilder category(SkillCategory category) {
        this.skill.setCategory(category);
        return this;
    }

    public Skill build() {
        return this.skill;
    }
}

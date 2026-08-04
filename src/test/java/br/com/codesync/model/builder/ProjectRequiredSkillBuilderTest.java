package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Project;
import br.com.codesync.model.entity.ProjectRequiredSkill;
import br.com.codesync.model.entity.Skill;
import br.com.codesync.model.enumerations.ProficiencyLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class ProjectRequiredSkillBuilderTest {

    @Test
    @DisplayName("Should create a project required skill with valid values")
    void shouldCreateProjectRequiredSkillWithValidValues() {
        UUID id = UUID.randomUUID();

        Project project = new Project();
        Skill skill = new Skill();

        ProjectRequiredSkill projectRequiredSkill = ProjectRequiredSkillBuilder.builder()
                .id(id)
                .project(project)
                .skill(skill)
                .proficiencyLevel(ProficiencyLevel.ADVANCED)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, projectRequiredSkill.getId()),
                () -> Assertions.assertEquals(project, projectRequiredSkill.getProject()),
                () -> Assertions.assertEquals(skill, projectRequiredSkill.getSkill()),
                () -> Assertions.assertEquals(
                        ProficiencyLevel.ADVANCED,
                        projectRequiredSkill.getProficiencyLevel())
        );
    }

    @Test
    @DisplayName("Should create an empty project required skill when no values are provided")
    void shouldCreateEmptyProjectRequiredSkillWhenNoValuesAreProvided() {
        ProjectRequiredSkill projectRequiredSkill = ProjectRequiredSkillBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(projectRequiredSkill.getId()),
                () -> Assertions.assertNull(projectRequiredSkill.getProject()),
                () -> Assertions.assertNull(projectRequiredSkill.getSkill()),
                () -> Assertions.assertNull(projectRequiredSkill.getProficiencyLevel())
        );
    }
}
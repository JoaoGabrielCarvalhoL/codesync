package br.com.codesync.model.builder;

import br.com.codesync.model.entity.ProfessionalProfile;
import br.com.codesync.model.entity.ProfessionalSkill;
import br.com.codesync.model.entity.Skill;
import br.com.codesync.model.enumerations.ProficiencyLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class ProfessionalSkillBuilderTest {

    @Test
    @DisplayName("Should create professional skill with valid values")
    void shouldCreateProfessionalSkillWithValidValues() {
        UUID id = UUID.randomUUID();

        Skill skill = new Skill();
        ProfessionalProfile profile = new ProfessionalProfile();

        ProfessionalSkill professionalSkill = defaultProfessionalSkillBuilder()
                .id(id)
                .skill(skill)
                .professionalProfile(profile)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, professionalSkill.getId()),
                () -> Assertions.assertEquals(ProficiencyLevel.ADVANCED, professionalSkill.getProficiencyLevel()),
                () -> Assertions.assertSame(skill, professionalSkill.getSkill()),
                () -> Assertions.assertSame(profile, professionalSkill.getProfessionalProfile())
        );
    }

    @Test
    @DisplayName("Should create empty professional skill when no values are provided")
    void shouldCreateEmptyProfessionalSkillWhenNoValuesAreProvided() {
        ProfessionalSkill professionalSkill = ProfessionalSkillBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(professionalSkill.getId()),
                () -> Assertions.assertNull(professionalSkill.getSkill()),
                () -> Assertions.assertNull(professionalSkill.getProficiencyLevel()),
                () -> Assertions.assertNull(professionalSkill.getProfessionalProfile())
        );
    }

    @Test
    @DisplayName("Should not share state between multiple builds")
    void shouldNotShareStateBetweenMultipleBuilds() {
        ProfessionalSkillBuilder builder = ProfessionalSkillBuilder.builder();

        ProfessionalSkill first = builder
                .proficiencyLevel(ProficiencyLevel.ADVANCED)
                .build();

        ProfessionalSkill second = builder
                .proficiencyLevel(ProficiencyLevel.BEGINNER)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(ProficiencyLevel.ADVANCED, first.getProficiencyLevel()),
                () -> Assertions.assertEquals(ProficiencyLevel.BEGINNER, second.getProficiencyLevel())
        );
    }

    private ProfessionalSkillBuilder defaultProfessionalSkillBuilder() {
        return ProfessionalSkillBuilder.builder()
                .proficiencyLevel(ProficiencyLevel.ADVANCED);
    }

}
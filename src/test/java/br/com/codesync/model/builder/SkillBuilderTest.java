package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Skill;
import br.com.codesync.model.enumerations.SkillCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class SkillBuilderTest {

    @Test
    @DisplayName("Should create skill with valid values")
    void shouldCreateSkillWithValidValues() {
        UUID id = UUID.randomUUID();

        Skill skill = defaultSkillBuilder()
                .id(id)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, skill.getId()),
                () -> Assertions.assertEquals("Java", skill.getName()),
                () -> Assertions.assertEquals(SkillCategory.LANGUAGE, skill.getCategory())
        );
    }

    @Test
    @DisplayName("Should create empty skill when no values are provided")
    void shouldCreateEmptySkillWhenNoValuesAreProvided() {
        Skill skill = SkillBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(skill.getId()),
                () -> Assertions.assertNull(skill.getName()),
                () -> Assertions.assertNull(skill.getCategory())
        );
    }

    @Test
    @DisplayName("Should not share state between multiple builds")
    void shouldNotShareStateBetweenMultipleBuilds() {
        SkillBuilder builder = SkillBuilder.builder();

        Skill first = builder
                .name("Java")
                .build();

        Skill second = builder
                .name("Python")
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals("Java", first.getName()),
                () -> Assertions.assertEquals("Python", second.getName())
        );
    }

    private SkillBuilder defaultSkillBuilder() {
        return SkillBuilder.builder()
                .name("Java")
                .category(SkillCategory.LANGUAGE);
    }

}
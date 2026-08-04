package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Project;
import br.com.codesync.model.entity.ProjectAccessInstruction;
import br.com.codesync.model.entity.ProjectEnvironment;
import br.com.codesync.model.enumerations.EnvironmentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

class ProjectEnvironmentBuilderTest {

    @Test
    @DisplayName("Should create a project environment with valid values")
    void shouldCreateProjectEnvironmentWithValidValues() {
        UUID id = UUID.randomUUID();

        Project project = new Project();
        ProjectAccessInstruction instruction = new ProjectAccessInstruction();

        List<ProjectAccessInstruction> instructions = List.of(instruction);

        ProjectEnvironment projectEnvironment = ProjectEnvironmentBuilder.builder()
                .id(id)
                .project(project)
                .name("Production")
                .environmentType(EnvironmentType.PRODUCTION)
                .url("https://production.codesync.com")
                .active(true)
                .instructions(instructions)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, projectEnvironment.getId()),
                () -> Assertions.assertEquals(project, projectEnvironment.getProject()),
                () -> Assertions.assertEquals("Production", projectEnvironment.getName()),
                () -> Assertions.assertEquals(EnvironmentType.PRODUCTION, projectEnvironment.getEnvironmentType()),
                () -> Assertions.assertEquals(
                        "https://production.codesync.com",
                        projectEnvironment.getUrl()),
                () -> Assertions.assertTrue(projectEnvironment.isActive()),
                () -> Assertions.assertEquals(instructions, projectEnvironment.getInstructions())
        );
    }

    @Test
    @DisplayName("Should create an empty project environment when no values are provided")
    void shouldCreateEmptyProjectEnvironmentWhenNoValuesAreProvided() {
        ProjectEnvironment projectEnvironment = ProjectEnvironmentBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(projectEnvironment.getId()),
                () -> Assertions.assertNull(projectEnvironment.getProject()),
                () -> Assertions.assertNull(projectEnvironment.getName()),
                () -> Assertions.assertNull(projectEnvironment.getEnvironmentType()),
                () -> Assertions.assertNull(projectEnvironment.getUrl()),
                () -> Assertions.assertTrue(projectEnvironment.isActive()),
                () -> Assertions.assertTrue(projectEnvironment.getInstructions().isEmpty())
        );
    }
}
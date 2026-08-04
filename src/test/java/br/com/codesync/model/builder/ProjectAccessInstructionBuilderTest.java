package br.com.codesync.model.builder;

import br.com.codesync.model.entity.ProjectAccessInstruction;
import br.com.codesync.model.entity.ProjectEnvironment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class ProjectAccessInstructionBuilderTest {

    @Test
    @DisplayName("Should create a project access instruction with valid values")
    void shouldCreateProjectAccessInstructionWithValidValues() {
        UUID id = UUID.randomUUID();

        ProjectEnvironment environment = new ProjectEnvironment();

        ProjectAccessInstruction projectAccessInstruction = ProjectAccessInstructionBuilder.builder()
                .id(id)
                .environment(environment)
                .title("VPN Access")
                .instructions("Connect to the corporate VPN before accessing the environment")
                .externalDocUrl("https://docs.codesync.com/vpn")
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, projectAccessInstruction.getId()),
                () -> Assertions.assertEquals(environment, projectAccessInstruction.getEnvironment()),
                () -> Assertions.assertEquals("VPN Access", projectAccessInstruction.getTitle()),
                () -> Assertions.assertEquals(
                        "Connect to the corporate VPN before accessing the environment",
                        projectAccessInstruction.getInstructions()),
                () -> Assertions.assertEquals(
                        "https://docs.codesync.com/vpn",
                        projectAccessInstruction.getExternalDocUrl())
        );
    }

    @Test
    @DisplayName("Should create an empty project access instruction when no values are provided")
    void shouldCreateEmptyProjectAccessInstructionWhenNoValuesAreProvided() {
        ProjectAccessInstruction projectAccessInstruction = ProjectAccessInstructionBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(projectAccessInstruction.getId()),
                () -> Assertions.assertNull(projectAccessInstruction.getEnvironment()),
                () -> Assertions.assertNull(projectAccessInstruction.getTitle()),
                () -> Assertions.assertNull(projectAccessInstruction.getInstructions()),
                () -> Assertions.assertNull(projectAccessInstruction.getExternalDocUrl())
        );
    }
}
package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Milestone;
import br.com.codesync.model.entity.Project;
import br.com.codesync.model.enumerations.MilestoneStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

class MilestoneBuilderTest {

    @Test
    @DisplayName("Should create a milestone with valid values")
    void shouldCreateMilestoneWithValidValues() {
        UUID id = UUID.randomUUID();
        LocalDate dueDate = LocalDate.now().plusDays(30);

        Project project = new Project();

        Milestone milestone = MilestoneBuilder.builder()
                .id(id)
                .project(project)
                .title("Backend Development")
                .description("Complete backend implementation")
                .dueDate(dueDate)
                .status(MilestoneStatus.IN_PROGRESS)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, milestone.getId()),
                () -> Assertions.assertEquals(project, milestone.getProject()),
                () -> Assertions.assertEquals("Backend Development", milestone.getTitle()),
                () -> Assertions.assertEquals("Complete backend implementation", milestone.getDescription()),
                () -> Assertions.assertEquals(dueDate, milestone.getDueDate()),
                () -> Assertions.assertEquals(MilestoneStatus.IN_PROGRESS, milestone.getStatus())
        );
    }

    @Test
    @DisplayName("Should create an empty milestone when no values are provided")
    void shouldCreateEmptyMilestoneWhenNoValuesAreProvided() {
        Milestone milestone = MilestoneBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(milestone.getId()),
                () -> Assertions.assertNull(milestone.getProject()),
                () -> Assertions.assertNull(milestone.getTitle()),
                () -> Assertions.assertNull(milestone.getDescription()),
                () -> Assertions.assertNull(milestone.getDueDate()),
                () -> Assertions.assertNull(milestone.getStatus())
        );
    }

}
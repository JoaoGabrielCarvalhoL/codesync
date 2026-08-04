package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Project;
import br.com.codesync.model.entity.Sprint;
import br.com.codesync.model.enumerations.SprintStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

class SprintBuilderTest {

    @Test
    @DisplayName("Should create a sprint with valid values")
    void shouldCreateSprintWithValidValues() {
        UUID id = UUID.randomUUID();

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusWeeks(2);

        Project project = new Project();

        Sprint sprint = SprintBuilder.builder()
                .id(id)
                .project(project)
                .goal("Implement user authentication flow")
                .startDate(startDate)
                .endDate(endDate)
                .status(SprintStatus.ACTIVE)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, sprint.getId()),
                () -> Assertions.assertEquals(project, sprint.getProject()),
                () -> Assertions.assertEquals(
                        "Implement user authentication flow",
                        sprint.getGoal()),
                () -> Assertions.assertEquals(startDate, sprint.getStartDate()),
                () -> Assertions.assertEquals(endDate, sprint.getEndDate()),
                () -> Assertions.assertEquals(SprintStatus.ACTIVE, sprint.getStatus())
        );
    }

    @Test
    @DisplayName("Should create an empty sprint when no values are provided")
    void shouldCreateEmptySprintWhenNoValuesAreProvided() {
        Sprint sprint = SprintBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(sprint.getId()),
                () -> Assertions.assertNull(sprint.getProject()),
                () -> Assertions.assertNull(sprint.getGoal()),
                () -> Assertions.assertNull(sprint.getStartDate()),
                () -> Assertions.assertNull(sprint.getEndDate()),
                () -> Assertions.assertNull(sprint.getStatus())
        );
    }
}
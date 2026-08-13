package br.com.codesync.model.builder;

import br.com.codesync.model.entity.AcceptanceCriteria;
import br.com.codesync.model.entity.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class AcceptanceCriteriaBuilderTest {

    @Test
    @DisplayName("Should create an acceptance criteria with valid values")
    void shouldCreateAcceptanceCriteriaWithValidValues() {
        UUID id = UUID.randomUUID();

        Task task = new Task();

        AcceptanceCriteria acceptanceCriteria = AcceptanceCriteriaBuilder.builder()
                .id(id)
                .task(task)
                .description("Task must be completed successfully")
                .notes("Acceptance criteria for task validation")
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, acceptanceCriteria.getId()),
                () -> Assertions.assertEquals(task, acceptanceCriteria.getTask()),
                () -> Assertions.assertEquals("Task must be completed successfully", acceptanceCriteria.getDescription()),
                () -> Assertions.assertEquals("Acceptance criteria for task validation", acceptanceCriteria.getNotes())
        );
    }

    @Test
    @DisplayName("Should create an empty acceptance criteria when no values are provided")
    void shouldCreateEmptyAcceptanceCriteriaWhenNoValuesAreProvided() {
        AcceptanceCriteria acceptanceCriteria = AcceptanceCriteriaBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(acceptanceCriteria.getId()),
                () -> Assertions.assertNull(acceptanceCriteria.getTask()),
                () -> Assertions.assertNull(acceptanceCriteria.getDescription()),
                () -> Assertions.assertNull(acceptanceCriteria.getNotes())
        );
    }
}

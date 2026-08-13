package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Blocker;
import br.com.codesync.model.entity.Task;
import br.com.codesync.model.entity.User;
import br.com.codesync.model.enumerations.TaskBlockerType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

class BlockerBuilderTest {

    @Test
    @DisplayName("Should create a blocker with valid values")
    void shouldCreateBlockerWithValidValues() {
        UUID id = UUID.randomUUID();
        LocalDateTime blockedAt = LocalDateTime.now();
        LocalDateTime unblockedAt = blockedAt.plusHours(2);

        Task task = new Task();
        User blockedBy = new User();
        User unblockedBy = new User();

        TaskBlockerType type = TaskBlockerType.CLIENT_DEPENDENCY;

        Blocker blocker = BlockerBuilder.builder()
                .id(id)
                .task(task)
                .type(type)
                .reason("External dependency is unavailable")
                .blockedBy(blockedBy)
                .blockedAt(blockedAt)
                .unblockedAt(unblockedAt)
                .unblockedBy(unblockedBy)
                .unblockNotes("External dependency became available")
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, blocker.getId()),
                () -> Assertions.assertEquals(task, blocker.getTask()),
                () -> Assertions.assertEquals(type, blocker.getType()),
                () -> Assertions.assertEquals("External dependency is unavailable", blocker.getReason()),
                () -> Assertions.assertEquals(blockedBy, blocker.getBlockedBy()),
                () -> Assertions.assertEquals(blockedAt, blocker.getBlockedAt()),
                () -> Assertions.assertEquals(unblockedAt, blocker.getUnblockedAt()),
                () -> Assertions.assertEquals(unblockedBy, blocker.getUnblockedBy()),
                () -> Assertions.assertEquals("External dependency became available", blocker.getUnblockNotes())
        );
    }

    @Test
    @DisplayName("Should create an empty blocker when no values are provided")
    void shouldCreateEmptyBlockerWhenNoValuesAreProvided() {
        Blocker blocker = BlockerBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(blocker.getId()),
                () -> Assertions.assertNull(blocker.getTask()),
                () -> Assertions.assertNull(blocker.getType()),
                () -> Assertions.assertNull(blocker.getReason()),
                () -> Assertions.assertNull(blocker.getBlockedBy()),
                () -> Assertions.assertNull(blocker.getBlockedAt()),
                () -> Assertions.assertNull(blocker.getUnblockedAt()),
                () -> Assertions.assertNull(blocker.getUnblockedBy()),
                () -> Assertions.assertNull(blocker.getUnblockNotes())
        );
    }
}
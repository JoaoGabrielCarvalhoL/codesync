package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Blocker;
import br.com.codesync.model.entity.Task;
import br.com.codesync.model.entity.User;
import br.com.codesync.model.enumerations.TaskBlockerType;

import java.time.LocalDateTime;
import java.util.UUID;

public class BlockerBuilder {

    private Blocker blocker;

    private BlockerBuilder() {
        this.blocker = new Blocker();
    }

    public static BlockerBuilder builder() {
        return new BlockerBuilder();
    }

    public BlockerBuilder id(UUID id) {
        this.blocker.setId(id);
        return this;
    }

    public BlockerBuilder task(Task task) {
        this.blocker.setTask(task);
        return this;
    }

    public BlockerBuilder type(TaskBlockerType type) {
        this.blocker.setType(type);
        return this;
    }

    public BlockerBuilder reason(String reason) {
        this.blocker.setReason(reason);
        return this;
    }

    public BlockerBuilder blockedBy(User blockedBy) {
        this.blocker.setBlockedBy(blockedBy);
        return this;
    }

    public BlockerBuilder blockedAt(LocalDateTime blockedAt) {
        this.blocker.setBlockedAt(blockedAt);
        return this;
    }

    public BlockerBuilder unblockedAt(LocalDateTime unblockedAt) {
        this.blocker.setUnblockedAt(unblockedAt);
        return this;
    }

    public BlockerBuilder unblockedBy(User unblockedBy) {
        this.blocker.setUnblockedBy(unblockedBy);
        return this;
    }

    public BlockerBuilder unblockNotes(String unblockNotes) {
        this.blocker.setUnblockNotes(unblockNotes);
        return this;
    }

    public Blocker build() {
        Blocker result = this.blocker;
        this.blocker = new Blocker();
        return result;
    }
}

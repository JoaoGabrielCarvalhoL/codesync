package br.com.codesync.model.entity;

import br.com.codesync.model.enumerations.TaskBlockerType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_blockers")
public class Blocker extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Task task;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskBlockerType type;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    private User blockedBy;

    @Column(nullable = false, name = "blocked_at")
    private LocalDateTime blockedAt;

    @Column(name = "unblocked_at")
    private LocalDateTime unblockedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User unblockedBy;

    @Column(name = "unblock_notes", columnDefinition = "TEXT")
    private String unblockNotes;

    public Blocker() {}

    public Blocker(Task task, TaskBlockerType type, String reason, User blockedBy, LocalDateTime blockedAt) {
        this.task = task;
        this.type = type;
        this.reason = reason;
        this.blockedBy = blockedBy;
        this.blockedAt = blockedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public TaskBlockerType getType() {
        return type;
    }

    public void setType(TaskBlockerType type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public User getBlockedBy() {
        return blockedBy;
    }

    public void setBlockedBy(User blockedBy) {
        this.blockedBy = blockedBy;
    }

    public LocalDateTime getBlockedAt() {
        return blockedAt;
    }

    public void setBlockedAt(LocalDateTime blockedAt) {
        this.blockedAt = blockedAt;
    }

    public LocalDateTime getUnblockedAt() {
        return unblockedAt;
    }

    public void setUnblockedAt(LocalDateTime unblockedAt) {
        this.unblockedAt = unblockedAt;
    }

    public User getUnblockedBy() {
        return unblockedBy;
    }

    public void setUnblockedBy(User unblockedBy) {
        this.unblockedBy = unblockedBy;
    }

    public String getUnblockNotes() {
        return unblockNotes;
    }

    public void setUnblockNotes(String unblockNotes) {
        this.unblockNotes = unblockNotes;
    }
}

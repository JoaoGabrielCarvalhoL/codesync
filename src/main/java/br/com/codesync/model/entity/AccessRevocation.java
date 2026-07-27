package br.com.codesync.model.entity;

import br.com.codesync.model.enumerations.RevocationStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_access_revocations")
public class AccessRevocation extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private ProjectMember projectMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private ProjectEnvironment projectEnvironment;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RevocationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private User revokedBy;

    private LocalDateTime revokedAt;

    @Column(columnDefinition = "TEXT")
    private String notes;

    public AccessRevocation() {}

    public AccessRevocation(ProjectMember projectMember, ProjectEnvironment projectEnvironment,
                            RevocationStatus status, User revokedBy, LocalDateTime revokedAt, String notes) {
        this.projectMember = projectMember;
        this.projectEnvironment = projectEnvironment;
        this.status = status;
        this.revokedBy = revokedBy;
        this.revokedAt = revokedAt;
        this.notes = notes;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProjectMember getProjectMember() {
        return projectMember;
    }

    public void setProjectMember(ProjectMember projectMember) {
        this.projectMember = projectMember;
    }

    public ProjectEnvironment getProjectEnvironment() {
        return projectEnvironment;
    }

    public void setProjectEnvironment(ProjectEnvironment projectEnvironment) {
        this.projectEnvironment = projectEnvironment;
    }

    public RevocationStatus getStatus() {
        return status;
    }

    public void setStatus(RevocationStatus status) {
        this.status = status;
    }

    public User getRevokedBy() {
        return revokedBy;
    }

    public void setRevokedBy(User revokedBy) {
        this.revokedBy = revokedBy;
    }

    public LocalDateTime getRevokedAt() {
        return revokedAt;
    }

    public void setRevokedAt(LocalDateTime revokedAt) {
        this.revokedAt = revokedAt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        AccessRevocation that = (AccessRevocation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

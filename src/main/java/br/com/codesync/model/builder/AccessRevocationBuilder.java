package br.com.codesync.model.builder;

import br.com.codesync.model.entity.*;
import br.com.codesync.model.enumerations.RevocationStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public final class AccessRevocationBuilder {

    private AccessRevocation accessRevocation;

    private AccessRevocationBuilder() {
        this.accessRevocation = new AccessRevocation();
    }

    public static AccessRevocationBuilder builder() {
        return new AccessRevocationBuilder();
    }

    public AccessRevocationBuilder id(UUID id) {
        this.accessRevocation.setId(id);
        return this;
    }

    public AccessRevocationBuilder projectMember(ProjectMember projectMember) {
        this.accessRevocation.setProjectMember(projectMember);
        return this;
    }

    public AccessRevocationBuilder projectEnvironment(ProjectEnvironment projectEnvironment) {
        this.accessRevocation.setProjectEnvironment(projectEnvironment);
        return this;
    }

    public AccessRevocationBuilder status(RevocationStatus status) {
        this.accessRevocation.setStatus(status);
        return this;
    }

    public AccessRevocationBuilder revokedBy(User user) {
        this.accessRevocation.setRevokedBy(user);
        return this;
    }

    public AccessRevocationBuilder revokedAt(LocalDateTime revokedAt) {
        this.accessRevocation.setRevokedAt(revokedAt);
        return this;
    }

    public AccessRevocationBuilder notes(String notes) {
        this.accessRevocation.setNotes(notes);
        return this;
    }

    public AccessRevocation build() {
        AccessRevocation result = this.accessRevocation;
        this.accessRevocation = new AccessRevocation();
        return result;
    }
}

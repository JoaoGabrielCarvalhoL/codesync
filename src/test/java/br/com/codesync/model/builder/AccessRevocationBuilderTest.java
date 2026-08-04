package br.com.codesync.model.builder;

import br.com.codesync.model.entity.AccessRevocation;
import br.com.codesync.model.entity.ProjectEnvironment;
import br.com.codesync.model.entity.ProjectMember;
import br.com.codesync.model.entity.User;
import br.com.codesync.model.enumerations.RevocationStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

class AccessRevocationBuilderTest {

    @Test
    @DisplayName("Should create an access revocation with valid values")
    void shouldCreateAccessRevocationWithValidValues() {
        UUID id = UUID.randomUUID();
        LocalDateTime revokedAt = LocalDateTime.now();

        ProjectMember projectMember = new ProjectMember();
        ProjectEnvironment projectEnvironment = new ProjectEnvironment();
        User revokedBy = new User();

        AccessRevocation accessRevocation = AccessRevocationBuilder.builder()
                .id(id)
                .projectMember(projectMember)
                .projectEnvironment(projectEnvironment)
                .status(RevocationStatus.REVOKED)
                .revokedBy(revokedBy)
                .revokedAt(revokedAt)
                .notes("Access revoked due to project completion")
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, accessRevocation.getId()),
                () -> Assertions.assertEquals(projectMember, accessRevocation.getProjectMember()),
                () -> Assertions.assertEquals(projectEnvironment, accessRevocation.getProjectEnvironment()),
                () -> Assertions.assertEquals(RevocationStatus.REVOKED, accessRevocation.getStatus()),
                () -> Assertions.assertEquals(revokedBy, accessRevocation.getRevokedBy()),
                () -> Assertions.assertEquals(revokedAt, accessRevocation.getRevokedAt()),
                () -> Assertions.assertEquals("Access revoked due to project completion", accessRevocation.getNotes())
        );
    }

    @Test
    @DisplayName("Should create an empty access revocation when no values are provided")
    void shouldCreateEmptyAccessRevocationWhenNoValuesAreProvided() {
        AccessRevocation accessRevocation = AccessRevocationBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(accessRevocation.getId()),
                () -> Assertions.assertNull(accessRevocation.getProjectMember()),
                () -> Assertions.assertNull(accessRevocation.getProjectEnvironment()),
                () -> Assertions.assertNull(accessRevocation.getStatus()),
                () -> Assertions.assertNull(accessRevocation.getRevokedBy()),
                () -> Assertions.assertNull(accessRevocation.getRevokedAt()),
                () -> Assertions.assertNull(accessRevocation.getNotes())
        );
    }
}
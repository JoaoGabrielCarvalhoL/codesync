package br.com.codesync.model.builder;

import br.com.codesync.model.entity.User;
import br.com.codesync.model.entity.UserAccess;
import br.com.codesync.model.enumerations.AccessStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class UserAccessBuilderTest {

    @Test
    @DisplayName("Should create user access with valid values")
    void shouldCreateUserAccessWithValidValues() {
        UUID id = UUID.randomUUID();
        User user = new User();

        UserAccess userAccess = defaultUserAccessBuilder()
                .id(id)
                .user(user)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, userAccess.getId()),
                () -> Assertions.assertEquals("session-123", userAccess.getKeycloakSessionId()),
                () -> Assertions.assertEquals("192.168.0.1", userAccess.getIpAddress()),
                () -> Assertions.assertEquals("Mozilla/5.0", userAccess.getUserAgent()),
                () -> Assertions.assertEquals("Desktop", userAccess.getDevice()),
                () -> Assertions.assertEquals("Chrome", userAccess.getBrowser()),
                () -> Assertions.assertEquals("Windows", userAccess.getOperatingSystem()),
                () -> Assertions.assertEquals("fp-xyz-123", userAccess.getDeviceFingerprint()),
                () -> Assertions.assertEquals("Brazil", userAccess.getCountry()),
                () -> Assertions.assertEquals("São Paulo", userAccess.getCity()),
                () -> Assertions.assertEquals(AccessStatus.ACTIVE, userAccess.getAccessStatus()),
                () -> Assertions.assertSame(user, userAccess.getUser())
        );
    }

    @Test
    @DisplayName("Should create empty user access when no values are provided")
    void shouldCreateEmptyUserAccessWhenNoValuesAreProvided() {
        UserAccess userAccess = UserAccessBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(userAccess.getId()),
                () -> Assertions.assertNull(userAccess.getKeycloakSessionId()),
                () -> Assertions.assertNull(userAccess.getIpAddress()),
                () -> Assertions.assertNull(userAccess.getUserAgent()),
                () -> Assertions.assertNull(userAccess.getDevice()),
                () -> Assertions.assertNull(userAccess.getBrowser()),
                () -> Assertions.assertNull(userAccess.getOperatingSystem()),
                () -> Assertions.assertNull(userAccess.getDeviceFingerprint()),
                () -> Assertions.assertNull(userAccess.getCountry()),
                () -> Assertions.assertNull(userAccess.getCity()),
                () -> Assertions.assertNull(userAccess.getAccessStatus()),
                () -> Assertions.assertNull(userAccess.getUser())
        );
    }

    @Test
    @DisplayName("Should not share state between multiple builds")
    void shouldNotShareStateBetweenMultipleBuilds() {
        UserAccessBuilder builder = UserAccessBuilder.builder();

        UserAccess first = builder
                .ipAddress("192.168.0.1")
                .build();

        UserAccess second = builder
                .ipAddress("10.0.0.1")
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals("192.168.0.1", first.getIpAddress()),
                () -> Assertions.assertEquals("10.0.0.1", second.getIpAddress())
        );
    }

    private UserAccessBuilder defaultUserAccessBuilder() {
        return UserAccessBuilder.builder()
                .keycloakSessionId("session-123")
                .ipAddress("192.168.0.1")
                .userAgent("Mozilla/5.0")
                .device("Desktop")
                .browser("Chrome")
                .operatingSystem("Windows")
                .deviceFingerprint("fp-xyz-123")
                .country("Brazil")
                .city("São Paulo")
                .accessStatus(AccessStatus.ACTIVE);
    }
}
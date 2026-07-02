package br.com.codesync.model.builder;

import br.com.codesync.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class UserBuilderTest {

    @Test
    @DisplayName("Should create user with valid values")
    void shouldCreateUserWithValidValues() {
        UUID id = UUID.randomUUID();

        User user = defaultUserBuilder()
                .id(id)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, user.getId()),
                () -> Assertions.assertEquals("codesync_user", user.getUsername()),
                () -> Assertions.assertEquals("user@codesync.com", user.getEmail()),
                () -> Assertions.assertEquals("Code", user.getFirstName()),
                () -> Assertions.assertEquals("Sync", user.getLastName()),
                () -> Assertions.assertTrue(user.getActive())
        );
    }

    @Test
    @DisplayName("Should create empty user when no values are provided")
    void shouldCreateEmptyUserWhenNoValuesAreProvided() {
        User user = UserBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(user.getId()),
                () -> Assertions.assertNull(user.getUsername()),
                () -> Assertions.assertNull(user.getEmail()),
                () -> Assertions.assertNull(user.getFirstName()),
                () -> Assertions.assertNull(user.getLastName()),
                () -> Assertions.assertTrue(user.getActive())
        );
    }

    @Test
    @DisplayName("Should not share state between multiple builds")
    void shouldNotShareStateBetweenMultipleBuilds() {
        UserBuilder builder = UserBuilder.builder();

        User first = builder
                .username("first_user")
                .build();

        User second = builder
                .username("second_user")
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals("first_user", first.getUsername()),
                () -> Assertions.assertEquals("second_user", second.getUsername())
        );
    }

    private UserBuilder defaultUserBuilder() {
        return UserBuilder.builder()
                .username("codesync_user")
                .email("user@codesync.com")
                .firstName("Code")
                .lastName("Sync")
                .active(true);
    }
}
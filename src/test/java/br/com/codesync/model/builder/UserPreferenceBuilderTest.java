package br.com.codesync.model.builder;

import br.com.codesync.model.entity.User;
import br.com.codesync.model.entity.UserPreference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class UserPreferenceBuilderTest {

    @Test
    @DisplayName("Should create user preference with valid values")
    void shouldCreateUserPreferenceWithValidValues() {
        UUID id = UUID.randomUUID();
        User user = new User();

        UserPreference preference = defaultUserPreferenceBuilder()
                .id(id)
                .user(user)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, preference.getId()),
                () -> Assertions.assertEquals("dark", preference.getTheme()),
                () -> Assertions.assertEquals("pt-BR", preference.getLocale()),
                () -> Assertions.assertEquals("America/Sao_Paulo", preference.getTimezone()),
                () -> Assertions.assertSame(user, preference.getUser())
        );
    }

    @Test
    @DisplayName("Should create empty user preference when no values are provided")
    void shouldCreateEmptyUserPreferenceWhenNoValuesAreProvided() {
        UserPreference preference = UserPreferenceBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(preference.getId()),
                () -> Assertions.assertNull(preference.getTheme()),
                () -> Assertions.assertNull(preference.getLocale()),
                () -> Assertions.assertNull(preference.getTimezone()),
                () -> Assertions.assertNull(preference.getUser())
        );
    }

    @Test
    @DisplayName("Should not share state between multiple builds")
    void shouldNotShareStateBetweenMultipleBuilds() {
        UserPreferenceBuilder builder = UserPreferenceBuilder.builder();

        UserPreference first = builder
                .theme("dark")
                .build();

        UserPreference second = builder
                .theme("light")
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals("dark", first.getTheme()),
                () -> Assertions.assertEquals("light", second.getTheme())
        );
    }

    private UserPreferenceBuilder defaultUserPreferenceBuilder() {
        return UserPreferenceBuilder.builder()
                .theme("dark")
                .locale("pt-BR")
                .timezone("America/Sao_Paulo");
    }

}
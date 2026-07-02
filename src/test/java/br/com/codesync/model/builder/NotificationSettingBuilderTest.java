package br.com.codesync.model.builder;

import br.com.codesync.model.entity.NotificationSetting;
import br.com.codesync.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class NotificationSettingBuilderTest {

    @Test
    @DisplayName("Should create notification setting with valid values")
    void shouldCreateNotificationSettingWithValidValues() {
        UUID id = UUID.randomUUID();
        User user = new User();

        NotificationSetting setting = defaultNotificationSettingBuilder()
                .id(id)
                .user(user)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, setting.getId()),
                () -> Assertions.assertTrue(setting.isEmailOnProjectMention()),
                () -> Assertions.assertTrue(setting.isEmailOnNewLogin()),
                () -> Assertions.assertTrue(setting.isEmailOnTaskAssigned()),
                () -> Assertions.assertTrue(setting.isPushEnabled()),
                () -> Assertions.assertSame(user, setting.getUser())
        );
    }

    @Test
    @DisplayName("Should create empty notification setting when no values are provided")
    void shouldCreateEmptyNotificationSettingWhenNoValuesAreProvided() {
        NotificationSetting setting = NotificationSettingBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(setting.getId()),
                () -> Assertions.assertFalse(setting.isEmailOnProjectMention()),
                () -> Assertions.assertFalse(setting.isEmailOnNewLogin()),
                () -> Assertions.assertFalse(setting.isEmailOnTaskAssigned()),
                () -> Assertions.assertFalse(setting.isPushEnabled()),
                () -> Assertions.assertNull(setting.getUser())
        );
    }

    @Test
    @DisplayName("Should not share state between multiple builds")
    void shouldNotShareStateBetweenMultipleBuilds() {
        NotificationSettingBuilder builder = NotificationSettingBuilder.builder();

        NotificationSetting first = builder
                .emailOnProjectMention(true)
                .build();

        NotificationSetting second = builder
                .emailOnProjectMention(false)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertTrue(first.isEmailOnProjectMention()),
                () -> Assertions.assertFalse(second.isEmailOnProjectMention())
        );
    }

    private NotificationSettingBuilder defaultNotificationSettingBuilder() {
        return NotificationSettingBuilder.builder()
                .emailOnProjectMention(true)
                .emailOnNewLogin(true)
                .emailOnTaskAssigned(true)
                .pushEnabled(true);
    }
}
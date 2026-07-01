package br.com.codesync.model.builder;

import br.com.codesync.model.entity.NotificationSetting;
import br.com.codesync.model.entity.User;

import java.util.UUID;

public class NotificationSettingBuilder {

    private NotificationSetting notificationSetting;

    public NotificationSettingBuilder() {
        this.notificationSetting = new NotificationSetting();
    }

    public static NotificationSettingBuilder builder() {
        return new NotificationSettingBuilder();
    }

    public NotificationSettingBuilder id(UUID id) {
        this.notificationSetting.setId(id);
        return this;
    }

    public NotificationSettingBuilder emailOnProjectMention(boolean emailOnProjectMention) {
        this.notificationSetting.setEmailOnProjectMention(emailOnProjectMention);
        return this;
    }

    public NotificationSettingBuilder emailOnNewLogin(boolean emailOnNewLogin) {
        this.notificationSetting.setEmailOnNewLogin(emailOnNewLogin);
        return this;
    }

    public NotificationSettingBuilder emailOnTaskAssigned(boolean emailOnTaskAssigned) {
        this.notificationSetting.setEmailOnTaskAssigned(emailOnTaskAssigned);
        return this;
    }

    public NotificationSettingBuilder pushEnabled(boolean pushEnabled) {
        this.notificationSetting.setPushEnabled(pushEnabled);
        return this;
    }

    public NotificationSettingBuilder user(User user) {
        this.notificationSetting.setUser(user);
        return this;
    }

    public NotificationSetting build() {
        return this.notificationSetting;
    }
}

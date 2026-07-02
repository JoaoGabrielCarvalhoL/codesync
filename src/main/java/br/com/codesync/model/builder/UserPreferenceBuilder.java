package br.com.codesync.model.builder;

import br.com.codesync.model.entity.User;
import br.com.codesync.model.entity.UserPreference;

import java.util.UUID;

public final class UserPreferenceBuilder {

    private UserPreference userPreference;

    private UserPreferenceBuilder() {
        this.userPreference = new UserPreference();
    }

    public static UserPreferenceBuilder builder() {
        return new UserPreferenceBuilder();
    }

    public UserPreferenceBuilder id(UUID id) {
        this.userPreference.setId(id);
        return this;
    }

    public UserPreferenceBuilder theme(String theme) {
        this.userPreference.setTheme(theme);
        return this;
    }

    public UserPreferenceBuilder locale(String locale) {
        this.userPreference.setLocale(locale);
        return this;
    }

    public UserPreferenceBuilder timezone(String timezone) {
        this.userPreference.setTimezone(timezone);
        return this;
    }

    public UserPreferenceBuilder user(User user) {
        this.userPreference.setUser(user);
        return this;
    }

    public UserPreference build() {
        UserPreference response = this.userPreference;
        this.userPreference = new UserPreference();
        return response;
    }
}

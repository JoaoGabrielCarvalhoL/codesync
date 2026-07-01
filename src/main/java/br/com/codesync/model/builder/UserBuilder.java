package br.com.codesync.model.builder;

import br.com.codesync.model.entity.User;

import java.util.UUID;

public final class UserBuilder {

    private final User user;

    private UserBuilder() {
        user = new User();
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public UserBuilder id(UUID id) {
        this.user.setId(id);
        return this;
    }

    public UserBuilder username(String username) {
        this.user.setUsername(username);
        return this;
    }

    public UserBuilder email(String email) {
        this.user.setEmail(email);
        return this;
    }

    public UserBuilder firstName(String firstName) {
        this.user.setFirstName(firstName);
        return this;
    }

    public UserBuilder lastName(String lastName) {
        this.user.setLastName(lastName);
        return this;
    }

    public UserBuilder active(Boolean active) {
        this.user.setActive(active);
        return this;
    }

    public User build() {
        return this.user;
    }
}

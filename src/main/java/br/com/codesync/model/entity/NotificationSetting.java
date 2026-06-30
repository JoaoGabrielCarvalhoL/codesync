package br.com.codesync.model.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_notification_settings")
public class NotificationSetting extends Auditable {

    @Id
    private UUID id;

    @Column(name = "email_on_new_login", nullable = false)
    private boolean emailOnNewLogin;

    @Column(name = "email_on_project_mention", nullable = false)
    private boolean emailOnProjectMention;

    @Column(name = "email_on_task_assigned", nullable = false)
    private boolean emailOnTaskAssigned;

    @Column(name = "push_enabled", nullable = false)
    private boolean pushEnabled;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public NotificationSetting() {}

    public NotificationSetting(User user) {
        this.emailOnNewLogin = true;
        this.emailOnProjectMention = true;
        this.emailOnTaskAssigned = true;
        this.pushEnabled = true;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isEmailOnNewLogin() {
        return emailOnNewLogin;
    }

    public void setEmailOnNewLogin(boolean emailOnNewLogin) {
        this.emailOnNewLogin = emailOnNewLogin;
    }

    public boolean isEmailOnProjectMention() {
        return emailOnProjectMention;
    }

    public void setEmailOnProjectMention(boolean emailOnProjectMention) {
        this.emailOnProjectMention = emailOnProjectMention;
    }

    public boolean isEmailOnTaskAssigned() {
        return emailOnTaskAssigned;
    }

    public void setEmailOnTaskAssigned(boolean emailOnTaskAssigned) {
        this.emailOnTaskAssigned = emailOnTaskAssigned;
    }

    public boolean isPushEnabled() {
        return pushEnabled;
    }

    public void setPushEnabled(boolean pushEnabled) {
        this.pushEnabled = pushEnabled;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        NotificationSetting that = (NotificationSetting) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

package br.com.codesync.model.builder;

import br.com.codesync.model.entity.User;
import br.com.codesync.model.entity.UserAccess;
import br.com.codesync.model.enumerations.AccessStatus;

import java.util.UUID;

public class UserAccessBuilder {

    private final UserAccess userAccess;

    private UserAccessBuilder() {
        this.userAccess = new UserAccess();
    }

    public static UserAccessBuilder builder() {
        return new UserAccessBuilder();
    }

    public UserAccessBuilder id(UUID id) {
        this.userAccess.setId(id);
        return this;
    }

    public UserAccessBuilder keycloakSessionId(String keycloakSessionId) {
        this.userAccess.setKeycloakSessionId(keycloakSessionId);
        return this;
    }

    public UserAccessBuilder ipAddress(String ipAddress) {
        this.userAccess.setIpAddress(ipAddress);
        return this;
    }

    public UserAccessBuilder userAgent(String userAgent) {
        this.userAccess.setUserAgent(userAgent);
        return this;
    }

    public UserAccessBuilder device(String device) {
        this.userAccess.setDevice(device);
        return this;
    }

    public UserAccessBuilder browser(String browser) {
        this.userAccess.setBrowser(browser);
        return this;
    }

    public UserAccessBuilder operatingSystem(String operatingSystem) {
        this.userAccess.setOperatingSystem(operatingSystem);
        return this;
    }

    public UserAccessBuilder deviceFingerprint(String deviceFingerprint) {
        this.userAccess.setDeviceFingerprint(deviceFingerprint);
        return this;
    }

    public UserAccessBuilder country(String country) {
        this.userAccess.setCountry(country);
        return this;
    }

    public UserAccessBuilder city(String city) {
        this.userAccess.setCity(city);
        return this;
    }

    public UserAccessBuilder accessStatus(AccessStatus  accessStatus) {
        this.userAccess.setAccessStatus(accessStatus);
        return this;
    }

    public UserAccessBuilder user(User user) {
        this.userAccess.setUser(user);
        return this;
    }

    public UserAccess build() {
        return this.userAccess;
    }
}

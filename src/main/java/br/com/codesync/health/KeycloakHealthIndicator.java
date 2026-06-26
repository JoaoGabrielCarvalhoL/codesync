package br.com.codesync.health;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component("keycloakHealth")
public class KeycloakHealthIndicator implements HealthIndicator {

    private final RestClient restClient;
    private final String keycloakBaseUrl;

    public KeycloakHealthIndicator(
                                   @Value("${keycloak-api.url}") String keycloakBaseUri) {
        this.keycloakBaseUrl = keycloakBaseUri;
        this.restClient = RestClient.builder().baseUrl(keycloakBaseUri).build();
    }

    @Override
    public @Nullable Health health() {
        if (this.keycloakBaseUrl == null || this.keycloakBaseUrl.isBlank()) {
            return Health.down()
                    .withDetail("reason", "OIDC URL not configured")
                    .build();
        }

        try {
            ResponseEntity<Void> response = restClient.get()
                    .uri("/realms/master/.well-known/openid-configuration")
                    .retrieve()
                    .toBodilessEntity();

            if (response.getStatusCode().is2xxSuccessful()) {
                return Health.up()
                        .withDetail("url", this.keycloakBaseUrl)
                        .build();
            } else {
                return Health.down()
                        .withDetail("status", response.getStatusCode().value())
                        .build();
            }

        } catch (Exception e) {
            return Health.down()
                    .withDetail("error", e.getClass().getSimpleName())
                    .withDetail("message", e.getMessage())
                    .build();
        }
    }
}

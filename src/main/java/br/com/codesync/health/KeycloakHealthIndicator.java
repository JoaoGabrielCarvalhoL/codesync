package br.com.codesync.health;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component("keycloakHealth")
public class KeycloakHealthIndicator implements HealthIndicator {

    private final RestClient restClient;
    private final String issuerUri;

    public KeycloakHealthIndicator(
            @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
            String issuerUri) {

        this.issuerUri = issuerUri;

        JdkClientHttpRequestFactory requestFactory =
                new JdkClientHttpRequestFactory();

        requestFactory.setReadTimeout(Duration.ofSeconds(3));

        this.restClient = RestClient.builder()
                .baseUrl(issuerUri)
                .requestFactory(requestFactory)
                .build();
    }

    @Override
    public Health health() {
        try {
            restClient.get()
                    .uri("/.well-known/openid-configuration")
                    .retrieve()
                    .toBodilessEntity();

            return Health.up()
                    .withDetail("issuer", issuerUri)
                    .build();

        } catch (Exception exception) {
            return Health.down()
                    .withDetail("error", exception.getClass().getSimpleName())
                    .build();
        }
    }
}
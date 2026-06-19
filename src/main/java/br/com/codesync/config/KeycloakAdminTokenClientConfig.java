package br.com.codesync.config;

import br.com.codesync.client.KeycloakAdminTokenClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class KeycloakAdminTokenClientConfig {

    private final String keycloakBaseUrl;

    public KeycloakAdminTokenClientConfig(@Value("${keycloak-api.url}") String keycloakBaseUrl) {
        this.keycloakBaseUrl = keycloakBaseUrl;
    }

    @Bean
    public KeycloakAdminTokenClient keycloakAdminTokenClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl(keycloakBaseUrl)
                .build();

        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(KeycloakAdminTokenClient.class);
    }
}

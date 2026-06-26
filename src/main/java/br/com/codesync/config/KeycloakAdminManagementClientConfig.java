package br.com.codesync.config;

import br.com.codesync.client.KeycloakAdminManagementClient;
import br.com.codesync.interceptor.KeycloakAuthInterceptor;
import br.com.codesync.service.IdentityProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class KeycloakAdminManagementClientConfig {

    private final String keycloakBaseUrl;

    public KeycloakAdminManagementClientConfig(@Value("${keycloak-api.url}") String keycloakBaseUrl) {
        this.keycloakBaseUrl = keycloakBaseUrl;
    }

    @Bean
    public KeycloakAdminManagementClient keycloakAdminManagementClient(IdentityProvider  identityProvider) {
        RestClient restClient = RestClient.builder()
                .baseUrl(keycloakBaseUrl)
                .requestInterceptor(new KeycloakAuthInterceptor(identityProvider))
                .build();

        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(KeycloakAdminManagementClient.class);
    }
}

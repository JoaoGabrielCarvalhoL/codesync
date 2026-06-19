package br.com.codesync.service.impl;

import br.com.codesync.client.KeycloakAdminTokenClient;
import br.com.codesync.client.dto.response.KeycloakTokenResponse;
import br.com.codesync.service.IdentityProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class KeycloakIdentityProviderImpl implements IdentityProvider {

    private final KeycloakAdminTokenClient keycloakAdminTokenClient;
    private final String realm;
    private final String clientId;
    private final String clientSecret;

    public KeycloakIdentityProviderImpl(KeycloakAdminTokenClient keycloakAdminTokenClient,
                                        @Value("${keycloak.realm}") String realm,
                                        @Value("${keycloak.client-id}") String clientId,
                                        @Value("${keycloak.client-secret}") String clientSecret) {
        this.keycloakAdminTokenClient = keycloakAdminTokenClient;
        this.realm = realm;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }


    @Cacheable(cacheNames = "keycloak-token")
    @Override
    public KeycloakTokenResponse generateToken() {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "client_credentials");
        formData.add("client_id", clientId);
        formData.add("client_secret", clientSecret);

        return this.keycloakAdminTokenClient.generateAdminToken(realm, formData);
    }
}

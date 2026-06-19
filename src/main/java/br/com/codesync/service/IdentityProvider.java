package br.com.codesync.service;

import br.com.codesync.client.dto.response.KeycloakTokenResponse;

public interface IdentityProvider {

    KeycloakTokenResponse generateToken();
}

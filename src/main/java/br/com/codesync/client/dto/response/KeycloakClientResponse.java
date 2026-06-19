package br.com.codesync.client.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record KeycloakClientResponse(
		String id, 
		String clientId, 
		String name, 
		Boolean serviceAccountsEnabled) {

}

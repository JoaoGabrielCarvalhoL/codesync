package br.com.codesync.client.dto.request;

public record KeycloakCredentialRequest(
		String type, 
		String value, 
		Boolean temporary) {

}

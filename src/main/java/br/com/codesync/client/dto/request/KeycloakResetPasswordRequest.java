package br.com.codesync.client.dto.request;

public record KeycloakResetPasswordRequest(
		String type, 
		String value, 
		Boolean temporary) {

}

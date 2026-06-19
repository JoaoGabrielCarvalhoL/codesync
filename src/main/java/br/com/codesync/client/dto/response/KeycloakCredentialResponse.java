package br.com.codesync.client.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record KeycloakCredentialResponse(
		String type, 
		String value, 
		Boolean temporary, 
		Long createdDate, 
		Long expiration) {

}

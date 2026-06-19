package br.com.codesync.client.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record KeycloakUserResponse(
		String id, 
		String username, 
		String email, 
		Boolean enabled, 
		Boolean emailVerified, 
		String firstName, 
		String lastName, 
		List<String> requiredActions,
		List<KeycloakCredentialResponse> credentials, 
		Map<String, List<String>> attributes,
		KeycloakAccessResponse access, 
		List<KeycloakFederatedIdentityResponse> federatedIdentities, 
		String notBefore, 
		String serviceAccountClientId, 
		List<String> disableableCredentialTypes, 
		Boolean totp) {

}

package br.com.codesync.client.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record KeycloakRoleResponse(
		String id, 
		String name, 
		String description, 
		Boolean composite, 
		Boolean clientRole, 
		String containerId) {

}

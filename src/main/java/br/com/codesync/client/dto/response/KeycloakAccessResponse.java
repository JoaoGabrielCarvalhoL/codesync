package br.com.codesync.client.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record KeycloakAccessResponse(
		Boolean manageGroupMembership, 
		Boolean view, 
		Boolean mapRoles, 
		Boolean impersonate, 
		Boolean manage, 
		Boolean manageToken) {

}

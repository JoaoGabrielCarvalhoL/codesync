package br.com.codesync.client.dto.request;

import java.util.List;

public record KeycloakExecuteActionsRequest(
		List<KeycloakRoleRequest> roles) {

}

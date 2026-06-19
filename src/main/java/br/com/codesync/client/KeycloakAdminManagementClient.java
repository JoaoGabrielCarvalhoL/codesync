package br.com.codesync.client;

import br.com.codesync.client.dto.request.KeycloakCreateUserRequest;
import br.com.codesync.client.dto.request.KeycloakResetPasswordRequest;
import br.com.codesync.client.dto.request.KeycloakUserAction;
import br.com.codesync.client.dto.response.KeycloakClientResponse;
import br.com.codesync.client.dto.response.KeycloakRoleResponse;
import br.com.codesync.client.dto.response.KeycloakUserResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.*;

import java.util.List;

@HttpExchange("/admin/realms/{realm}")
public interface KeycloakAdminManagementClient {

    @PostExchange(value = "/users", contentType = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> createUser(@PathVariable("realm") String realm, @RequestBody KeycloakCreateUserRequest body);

    @GetExchange(value = "/users", accept = MediaType.APPLICATION_JSON_VALUE)
    List<KeycloakUserResponse> getUsers(
            @PathVariable("realm") String realm,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "first", required = false) Integer first,
            @RequestParam(value = "max", required = false) Integer max
    );

    @GetExchange(value = "/users/count", accept = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Long> getUsersCount(
            @PathVariable("realm") String realm,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "email", required = false) String email
    );

    @GetExchange(value = "/users/{id}", accept = MediaType.APPLICATION_JSON_VALUE)
    KeycloakUserResponse getUserById(@PathVariable("realm") String realm, @PathVariable("id") String id);

    @PutExchange(value = "/users/{id}", contentType = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> updateUser(@PathVariable("realm") String realm, @PathVariable("id") String id, @RequestBody KeycloakCreateUserRequest body);

    @DeleteExchange("/users/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable("realm") String realm, @PathVariable("id") String id);

    @PutExchange(value = "/users/{id}/reset-password", contentType = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> resetPassword(@PathVariable("realm") String realm, @PathVariable("id") String id, @RequestBody KeycloakResetPasswordRequest body);

    @PutExchange(value = "/users/{id}/execute-actions-email", contentType = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> executeActionsEmail(@PathVariable("realm") String realm, @PathVariable("id") String id, @RequestBody List<KeycloakUserAction> actions);

    @PostExchange("/users/{id}/logout")
    ResponseEntity<Void> logoutUser(@PathVariable("realm") String realm, @PathVariable("id") String id);

    @GetExchange(value = "/roles/{role-name}", accept = MediaType.APPLICATION_JSON_VALUE)
    KeycloakRoleResponse getRoleByName(@PathVariable("realm") String realm, @PathVariable("role-name") String roleName);

    @PostExchange(value = "/users/{id}/role-mappings/realm", contentType = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> assignRealmRoles(@PathVariable("realm") String realm, @PathVariable("id") String id, @RequestBody List<KeycloakRoleResponse> roles);

    @GetExchange(value = "/users/{id}/role-mappings", accept = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getUserRoleMappings(@PathVariable("realm") String realm, @PathVariable("id") String id);

    @GetExchange(value = "/users/{id}/groups", accept = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getUserGroups(@PathVariable("realm") String realm, @PathVariable("id") String id);

    @PutExchange("/users/{id}/groups/{groupId}")
    ResponseEntity<Void> addUserToGroup(@PathVariable("realm") String realm, @PathVariable("id") String id, @PathVariable("groupId") String groupId);

    @DeleteExchange("/users/{id}/groups/{groupId}")
    ResponseEntity<Void> removeUserFromGroup(@PathVariable("realm") String realm, @PathVariable("id") String id, @PathVariable("groupId") String groupId);

    @GetExchange(value = "/users/{id}/sessions", accept = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getUserSessions(@PathVariable("realm") String realm, @PathVariable("id") String id);

    @GetExchange(value = "/clients", accept = MediaType.APPLICATION_JSON_VALUE)
    List<KeycloakClientResponse> getClients(@PathVariable("realm") String realm);

    @GetExchange(value = "/clients/{clientId}/roles", accept = MediaType.APPLICATION_JSON_VALUE)
    List<KeycloakRoleResponse> getClientRoles(@PathVariable("realm") String realm, @PathVariable("clientId") String clientId);

    @PostExchange(value = "/clients/{clientId}/service-account-user/role-mappings/clients/{roleClientId}", contentType = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> assignClientRolesToServiceAccount(
            @PathVariable("realm") String realm,
            @PathVariable("clientId") String clientId,
            @PathVariable("roleClientId") String roleClientId,
            @RequestBody List<KeycloakRoleResponse> roles
    );

    @GetExchange(value = "/clients/{clientId}/service-account-user", accept = MediaType.APPLICATION_JSON_VALUE)
    KeycloakUserResponse getServiceAccountUser(@PathVariable("realm") String realm, @PathVariable("clientId") String clientId);
}


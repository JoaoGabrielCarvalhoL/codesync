package br.com.codesync.controller;

import br.com.codesync.client.KeycloakAdminManagementClient;
import br.com.codesync.client.dto.request.KeycloakCreateUserRequest;
import br.com.codesync.client.dto.request.KeycloakCredentialRequest;
import br.com.codesync.client.dto.response.KeycloakTokenResponse;
import br.com.codesync.service.IdentityProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/test")
public class KeycloakTestController {

    private static final Logger logger = LoggerFactory.getLogger(KeycloakTestController.class);

    private final IdentityProvider identityProvider;
    private final KeycloakAdminManagementClient keycloakAdminManagementClient;

    public KeycloakTestController(IdentityProvider identityProvider,
                          KeycloakAdminManagementClient keycloakAdminManagementClient) {
        this.identityProvider = identityProvider;
        this.keycloakAdminManagementClient = keycloakAdminManagementClient;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KeycloakTokenResponse> generateToken() {
        logger.info("Generating token...");
        KeycloakTokenResponse token = identityProvider.generateToken();
        logger.info("Token generated successfully!");
        return ResponseEntity.ok(token);
    }

    @PostMapping
    public ResponseEntity<String> createUser() {
        KeycloakCredentialRequest password = new KeycloakCredentialRequest("password", "123456789", false);

        KeycloakCreateUserRequest userRequest = new KeycloakCreateUserRequest(
                "testeuser",
                "testeuser@example.com",
                true,
                true,
                "Teste",
                "User",
                List.of(),
                List.of(password),
                Map.of()
        );

        ResponseEntity<Void> response = keycloakAdminManagementClient.createUser("codesync", userRequest);

        if (response.getStatusCode().equals(HttpStatus.CREATED)) {
            URI location = response.getHeaders().getLocation();
            return ResponseEntity.ok(location != null ? location.toString() : "User created successfully!");
        } else {
            return ResponseEntity.status(response.getStatusCode())
                    .body("Failed to create user: " + response.getBody());
        }
    }
}

package br.com.codesync.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/ping")
public class PingController {

    @GetMapping("/protected")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Map<String, Object>> protectedPing(@AuthenticationPrincipal Jwt jwt) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("message", "Pong! Protected endpoint accessed successfully.");
        response.put("username", jwt.getClaimAsString("preferred_username"));
        response.put("role", jwt.getClaim("realm_access"));
        response.put("email", jwt.getClaimAsString("email"));
        response.put("userId", jwt.getSubject());

        return ResponseEntity.ok(response);
    }
}

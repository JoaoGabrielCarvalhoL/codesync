package br.com.codesync.client;

import br.com.codesync.client.dto.response.KeycloakTokenResponse;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("/realms/{realm}/protocol/openid-connect")
public interface KeycloakAdminTokenClient {

    @PostExchange(value = "/token", contentType = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    KeycloakTokenResponse generateAdminToken(
            @PathVariable("realm") String realm,
            @RequestBody MultiValueMap<String, String> formData
    );
}

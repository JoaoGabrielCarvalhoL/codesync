package br.com.codesync.interceptor;

import br.com.codesync.client.dto.response.KeycloakTokenResponse;
import br.com.codesync.service.IdentityProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class KeycloakAuthInterceptor implements ClientHttpRequestInterceptor {

    private final IdentityProvider identityProvider;
    private static final Logger logger = LoggerFactory.getLogger(KeycloakAuthInterceptor.class);

    public KeycloakAuthInterceptor(IdentityProvider identityProvider) {
        this.identityProvider = identityProvider;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        String path = request.getURI().getPath();
        if (!path.contains("/token")) {
            KeycloakTokenResponse response = identityProvider.generateToken();

            logger.info("Using token: {}", response.accessToken());
            logger.info("Setting Authorization header for request to {}", request.getURI());

            request.getHeaders().setBearerAuth(response.accessToken());
        }

        return execution.execute(request, body);
    }
}


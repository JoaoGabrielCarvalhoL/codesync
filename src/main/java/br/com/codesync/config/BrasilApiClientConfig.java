package br.com.codesync.config;

import br.com.codesync.client.BrasilApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class BrasilApiClientConfig {

    private final String brasilApiBaseUrl;

    public BrasilApiClientConfig(@Value("${brasil-api.url}") String brasilApiUrl) {
        brasilApiBaseUrl = brasilApiUrl;
    }

    @Bean
    public BrasilApiClient brasilApiClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl(brasilApiBaseUrl)
                .build();

        RestClientAdapter restClientAdapter = RestClientAdapter.create(restClient);

        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return factory.createClient(BrasilApiClient.class);
    }
}

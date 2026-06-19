package br.com.codesync.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

@Configuration
public class AmazonS3Config {

    private final String endpointUrl;
    private final String region;
    private final String accessKey;
    private final String secretKey;

    public AmazonS3Config(@Value("${aws.s3.endpoint-url}") String endpointUrl,
                          @Value("${aws.s3.region}") String region,
                          @Value("${aws.s3.access-key}") String accessKey,
                          @Value("${aws.s3.secret-key}") String secretKey) {
        this.endpointUrl = endpointUrl;
        this.region = region;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @Bean
    public S3Client s3Client() {
        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);

        return S3Client.builder()
                .endpointOverride(URI.create(endpointUrl))
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .httpClientBuilder(UrlConnectionHttpClient.builder())
                .build();
    }
}

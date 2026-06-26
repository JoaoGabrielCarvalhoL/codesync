package br.com.codesync.health;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.s3.S3Client;

@Component("s3Health")
public class S3HealthIndicator implements HealthIndicator {

    private final S3Client s3Client;

    public S3HealthIndicator(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public @Nullable Health health() {
        try {
            this.s3Client.listBuckets();
            return Health.up()
                    .withDetail("service", "Amazon S3 connection is healthy")
                    .build();
        } catch (Exception e) {
            return Health.down()
                    .withDetail("error", "Failed to connect to Amazon S3")
                    .withDetail("cause", e.getClass().getSimpleName())
                    .withDetail("message", e.getMessage())
                    .build();
        }
    }
}

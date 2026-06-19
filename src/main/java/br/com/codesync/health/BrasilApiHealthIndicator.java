package br.com.codesync.health;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("brasilApiHealth")
public class BrasilApiHealthIndicator implements HealthIndicator {
    @Override
    public @Nullable Health health() {
        return null;
    }
}

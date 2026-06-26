package br.com.codesync.health;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@Component("brasilApiHealth")
public class BrasilApiHealthIndicator implements HealthIndicator {
    @Override
    public @Nullable Health health() {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("brasilapi.com.br", 443), 2000);

            return Health.up()
                    .withDetail("network", "Connection to BrasilAPI host is stable")
                    .build();
        } catch (IOException e) {
            return Health.down()
                    .withDetail("error", "Cannot reach BrasilAPI host via network")
                    .withDetail("cause", e.getClass().getSimpleName())
                    .build();
        }
    }
}

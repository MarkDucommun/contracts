package io.pivotal.chicago.contracts.example;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

@RunWith(PactRunner.class)
public abstract class ProviderTest {
    protected Integer port;

    protected Integer getRandomPort() throws IOException {
        ServerSocket serverSocket = new ServerSocket(0);
        Integer port = serverSocket.getLocalPort();
        serverSocket.close();
        return port;
    }

    public abstract Class<?> getApplicationClass();


    @Before
    public void setUp() throws Exception {
        port = getRandomPort();

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("server.port", port);

        new SpringApplicationBuilder()
                .sources(getApplicationClass())
                .properties(properties)
                .run();
    }

    @TestTarget
    public final Target target = new LazyHttpTarget(() -> port);
}

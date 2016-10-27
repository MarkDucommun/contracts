package io.pivotal.chicago.contracts.example;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;

@RunWith(PactRunner.class)
@Provider("TodoProviderService")
@PactFolder("src/test/resources/contracts")
public class TodosControllerTest {

    @Before
    public void setUp() throws Exception {
        SpringApplication.run(TodoProviderServiceApplication.class);
    }

    @TestTarget
    public final Target target = new HttpTarget(8080);
}

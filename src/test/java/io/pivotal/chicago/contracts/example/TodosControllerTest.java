package io.pivotal.chicago.contracts.example;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;


@Provider("TodoProviderService")
@PactFolder("src/test/resources/contracts")
public class TodosControllerTest extends ProviderTest {

    @Override
    public Class<?> getApplicationClass() {

        return TodoProviderServiceApplication.class;
    }
}

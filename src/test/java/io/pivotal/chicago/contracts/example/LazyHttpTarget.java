package io.pivotal.chicago.contracts.example;

import au.com.dius.pact.model.Interaction;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.TestClassAwareTarget;
import org.junit.runners.model.TestClass;

import java.util.function.IntSupplier;

public class LazyHttpTarget implements TestClassAwareTarget {
    private IntSupplier portSupplier;
    private Object testTarget;
    private TestClass testClass;

    public LazyHttpTarget(IntSupplier portSupplier) {
        this.portSupplier = portSupplier;
    }

    @Override
    public void testInteraction(String consumer, Interaction interaction) {
        HttpTarget httpTarget = new HttpTarget(portSupplier.getAsInt());
        httpTarget.setTestClass(testClass, testTarget);
        httpTarget.testInteraction(consumer, interaction);
    }

    @Override
    public void setTestClass(TestClass testClass, Object testTarget) {
        this.testClass = testClass;
        this.testTarget = testTarget;
    }
}
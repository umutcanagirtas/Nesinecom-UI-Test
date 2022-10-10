package helpers;

import base.BaseClass;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import io.qameta.allure.Allure;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.util.List;

public class TestListener implements ConcurrentEventListener {
    private int i = 0;

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
        publisher.registerHandlerFor(TestStepStarted.class, this::takeScreenShotBeforeTestStep);
    }

    private void takeScreenShotBeforeTestStep(TestStepStarted testStepStarted) {
    }

    private void handleTestStepFinished(TestStepFinished event) {
        Status status = event.getResult().getStatus();
        Throwable error = event.getResult().getError();
        String scenarioName = event.getTestCase().getName();
        List<TestStep> testSteps = event.getTestCase().getTestSteps();
        if (i != testSteps.size() - 2) {
            i++;
        }
        String stepName = (((PickleStepTestStep) testSteps.get(i)).getStep()).getText();
        BasicConfigurator.configure();
        switch (status) {
            case PASSED:
                Log.information("The case named '" + stepName + "' in '"+scenarioName+"' scenario became PASSED");
                break;
            case FAILED:
                Allure.addAttachment("Page Screenshot", new ByteArrayInputStream(((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES)));
                Log.error("The case named '" + stepName + "' in '"+scenarioName+"' scenario became FAILED on'" + "'\nError Details:\n" + error);
                break;
            case SKIPPED:
            case PENDING:
            case UNDEFINED:
            case AMBIGUOUS:
            case UNUSED:
                break;

        }
    }
}
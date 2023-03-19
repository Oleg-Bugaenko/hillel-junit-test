package ua.hillel.testrunner;

import org.junit.platform.reporting.shadow.org.opentest4j.reporting.events.core.Data;

import java.util.Date;

public class TestResult {
    private int totalNumberTests;

    private int testsSuccessful;

    private int testsFailed;

    private int testExecutionTime;


    public void setTotalNumberTests(int totalNumberTests) {
        this.totalNumberTests = totalNumberTests;
    }

    public void setTestsSuccessful(int testsSuccessful) {
        this.testsSuccessful = testsSuccessful;
    }

    public void setTestsFailed(int testsFailed) {
        this.testsFailed = testsFailed;
    }

    public void setTestExecutionTime(int testExecutionTime) {
        this.testExecutionTime = testExecutionTime;
    }

    @Override
    public String toString() {
        return "TestResult: " +
                "\n test execution time: " + testExecutionTime + " ms" +
                "\n total number tests: " + totalNumberTests +
                "\n tests successful: " + testsSuccessful +
                "\n tests failed: " + testsFailed;
    }
}

package ua.hillel;

import ua.hillel.mathlibrary.ParseArrayTest;
import ua.hillel.mathlibrary.SimpleMathLibraryTest;
import ua.hillel.testrunner.ProjectTestRunner;
import ua.hillel.testrunner.TestResult;
import ua.hillel.testrunner.TestResultParser;

import java.io.*;

public class TestRunner {
    private static final String filePathResultTest = "src/ResultTest.txt";

    public static void main(String[] args) {


        ProjectTestRunner testRunner = new ProjectTestRunner(filePathResultTest);
//  1) - Запуск тестів:
        // Запуск тесту "тип даних класс"
        testRunner.runTestForClass(SimpleMathLibraryTest.class, ParseArrayTest.class);

        // Запуск тесту за розташуванням у пакеті
        // testRunner.runByPackageName("ua.hillel.mathlibrary");

        // Запуск тесту за ім'ям класу
        // testRunner.runTestForClass("ua.hillel.mathlibrary.SimpleMathLibraryTest", "ua.hillel.mathlibrary.ParseArrayTest");


//  2) - створення об'єкту TestResultParser та мапинг результатів тестів в об'єкт TestResult
        TestResultParser testResultParser = new TestResultParser();

        TestResult testResult = testResultParser.parse(filePathResultTest);
        System.out.println(testResult.toString());

        /*File file = new File(filePathResultTest);
        TestResult testResult1 = testResultParser.parse(file);
        System.out.println(testResult1.toString());*/


    }
}

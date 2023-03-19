package ua.hillel.testrunner;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestResultParser {
    List<TestResult> list = new ArrayList<>();

    public TestResult parse(String path) {
        return parseTestResultFile(path);
    }

    public TestResult parse(File file) {
        return parseTestResultFile(file.getPath());
    }

    public TestResult parse(Path path) {
        return parseTestResultFile(path.toString());
    }

    private TestResult parseTestResultFile(String patch) {
        TestResult testResult = new TestResult();
        try (Reader reader = new FileReader(patch)) {
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();
            String[] strings = line.split(" ");
            testResult.setTestExecutionTime(Integer.parseInt(strings[4]));
            int count = 0;
            while (bufferedReader.ready()) {
                count++;
                line = bufferedReader.readLine();
                switch (count) {
                    case 7 -> testResult.setTotalNumberTests(parseString(line));
                    case 11 -> testResult.setTestsSuccessful(parseString(line));
                    case 12 -> testResult.setTestsFailed(parseString(line));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return testResult;
    }

    private int parseString(String source) {
        char[] chars = source.toCharArray();
        String count = "";
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != ' ') {
                while (chars[i] != ' ') {
                    char ch = chars[i];
                    count = count + ch;
                    i++;
                }
                return Integer.parseInt(count);
            }
        }
        return 0;
    }

}

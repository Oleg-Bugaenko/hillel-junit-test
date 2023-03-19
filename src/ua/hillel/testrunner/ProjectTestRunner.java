package ua.hillel.testrunner;

import org.junit.platform.console.ConsoleLauncher;

import java.io.*;

public class ProjectTestRunner {
    private String filePathResultTest = "src/ResultTest.txt";
    public ProjectTestRunner() {}
    public ProjectTestRunner(String filePathResultTest) {
        this.filePathResultTest = filePathResultTest;
    }

    public void setFilePathResultTest(String filePathResultTest) {
        this.filePathResultTest = filePathResultTest;
    }


    //запуск тесту за іменами класів
    public void runTestForClass(String... className) {
        String[] args = new String[className.length];
        for (int i = 0; i < args.length; i++) {
            args[i] = "-c" + className[i];
        }
        runConsoleLauncher(args);
    }

    //запуск тесту (тип даних клас)
    public void runTestForClass(Class<?>... classType) {
        String[] args = new String[classType.length];
        for (int i = 0; i < args.length; i++) {
            args[i] = "-c" + classType[i].getName();
        }
        runConsoleLauncher(args);
    }

    //запуск тесту за ім'ям пакету
    public void runByPackageName(String packageName) {
        String param = "-p" + packageName;
        runConsoleLauncher(param);
    }


    private void runConsoleLauncher(String...param) {
        try (ByteArrayOutputStream outputWriter = new ByteArrayOutputStream()) {
            PrintStream out = new PrintStream(outputWriter);
            PrintStream err = System.err;
            ConsoleLauncher.execute(out, err, param);
            writeResultTest(outputWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void writeResultTest(ByteArrayOutputStream outputWriter) {
        //Вивід результатів тесту в консоль
        System.out.println(outputWriter);

        //Вивід результатів тесту у файл
        try (OutputStream outputStream = new FileOutputStream(filePathResultTest)) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

            String[] strings = outputWriter.toString().split("\n");
            StringBuilder stringBuilder = new StringBuilder();
            int j = 0;
            for (int i = 0; i < strings.length; i++) {
                if (j >= 3) stringBuilder.append(strings[i]);
                if (strings[i].equals("\r")) j++;
            }

            bufferedWriter.write(new String(stringBuilder));
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

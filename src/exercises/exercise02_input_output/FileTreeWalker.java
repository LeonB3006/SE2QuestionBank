package exercises.exercise02_input_output;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 *  Modifizieren Sie das Programm so, dass es die Dateien nach fallender
 *  Länge sortiert ausgibt.
 */

public class FileTreeWalker {



    public static void main(String[] args) throws IOException {
        new FileTreeWalker().walk(args[0]);
    }

    void walk(String pathname) throws IOException {
        File[] files = new File(pathname).listFiles();
        if (files != null)
            for (File file : files)
                if (file.isDirectory())
                    walk(file.getCanonicalPath());
                else
                    process(file.getCanonicalPath(), (int) file.length());

    }

    void process(String name, int length) {
        System.out.printf("%-70s%9d%n", name, length);
    }
}


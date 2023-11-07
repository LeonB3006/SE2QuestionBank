package exercises.exercise02_input_output;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *  Modifizieren Sie das Programm so, dass es die Dateien nach fallender
 *  Länge sortiert ausgibt.
 */

public class FileTreeWalker {

    public static void main(String[] args) throws IOException {
        FileTreeWalker walker = new FileTreeWalker();

        List<File> files = walker.walk(args[0]);

        files.stream()
                .sorted(Comparator.comparingLong(File::length))
                .forEach(f -> {
                    try {
                        walker.process(f.getCanonicalPath(), (int)f.length());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    List<File> walk(String pathname) throws IOException {
        File[] files = new File(pathname).listFiles();
        List<File> allFiles = new ArrayList<>();

        if (files != null)
            for (File file : files)
                if (file.isDirectory())
                    allFiles.addAll(walk(file.getCanonicalPath()));
                else
                    allFiles.add(file);

        return allFiles;
    }

    void process(String name, int length) {
        System.out.printf("%-70s%9d%n", name, length);
    }
}


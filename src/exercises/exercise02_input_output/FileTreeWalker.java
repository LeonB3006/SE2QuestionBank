package exercises.exercise02_input_output;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  Modifizieren Sie das Programm so, dass es die Dateien nach fallender
 *  Länge sortiert ausgibt.
 */

public class FileTreeWalker {

    public static void main(String[] args) throws IOException {
        new FileTreeWalker().walk(args[0]);
    }

    void walk(String pathname) throws IOException {
        try (Stream<Path> paths = Files.walk(Paths.get(pathname))) {
            paths
                    .sorted(Comparator.comparing(f -> f.toFile().length(), Comparator.reverseOrder()))
                    .forEach(f -> process(f.toFile().getName(), (int)f.toFile().length()));
        }
    }

    void process(String name, int length) {
        System.out.printf("%-70s%9d%n", name, length);
    }
}


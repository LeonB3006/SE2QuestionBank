package exercises.exercise02_input_output;


import java.io.*;
import java.nio.file.Path;

public class FileFun implements FileAndPath{

    @Override
    public void hemmingDistance(Path file1, Path file2) {
        File f1 = new File(file1.toUri());
        File f2 = new File(file2.toUri());

        try (FileReader fileReader1 = new FileReader(f1);
             FileReader fileReader2 = new FileReader(f2)) {
            String fileContent1 = fileReader1.toString();
            String fileContent2 = fileReader2.toString();

            if (fileContent1.length() != fileContent2.length()) {
                System.out.println("String do not match in length.");
                return;
            }

            int count = 0;
            for (int i = 0; i < fileContent1.length(); i++) {
                if (fileContent1.charAt(i) != fileContent2.charAt(i))
                    count++;
            }

            System.out.println("Hamming Distance: " + count);
        } catch (IOException e) {
            System.err.println("Failed to read file:" + e.getMessage());
        }
    }

    @Override
    public void convertToLowercase(Path inPath, Path outPath) {
        File inFile = new File(inPath.toUri());
        File outFile = new File(outPath.toUri());
        try (FileReader inFileReader = new FileReader(inFile);
             FileWriter outFileWriter = new FileWriter(outFile)) {
            String inFileContent = inFileReader.toString();
            outFileWriter.write(inFileContent.toUpperCase());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void readLineByLine(Path file) {
        File in = new File(file.toUri());
        try (FileReader fileReader = new FileReader(in);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            bufferedReader
                    .lines()
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void countWordsOfFile(Path file) {
        File in = new File(file.toUri());
        try (FileReader fileReader = new FileReader(in)) {
            String fileContent = fileReader.toString();
            int wordCount = fileContent.split(" ").length;
            System.out.println("Word Count: " + wordCount);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

package exercises.exercise02_input_output;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileFun implements FileAndPath{

    @Override
    public void hemmingDistance(Path file1, Path file2) throws IOException {
        long fileSize1 = Files.size(file1);
        long fileSize2 = Files.size(file2);

        if(fileSize1 != fileSize2)
            throw new IllegalStateException("File size ist not equal");

        int distance = 0;
        try(Reader reader1 = Files.newBufferedReader(file1);
            Reader reader2 = Files.newBufferedReader(file2)) {

            for (int pointer = 0; pointer < fileSize1; pointer++) {
                if (reader1.read() != reader2.read())
                    distance++;
            }
        }
        System.out.println(distance);

    }

    @Override
    public void convertToLowercase(Path inPath, Path outPath) {

        try(BufferedReader reader = Files.newBufferedReader(inPath);
            BufferedWriter writer = Files.newBufferedWriter(outPath)){

            int character= reader.read();

            while(character >= 0){
                writer.write(Character.toLowerCase(character));
                character = reader.read();
            }
            writer.flush();

    } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void readLineByLine(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)){

            String line;
            while((line =reader.readLine()) != null){  // Achtung bei Vergleich wird automatisch schon gelesen
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void countWordsOfFile(Path file) {

        try(Scanner myScanner = new Scanner(file)){

            int wordCount = 0;
            while(myScanner.hasNext()){
                wordCount++;
                myScanner.next();
            }
            System.out.println(wordCount);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}



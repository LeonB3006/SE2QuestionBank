package exercises.exercise02_input_output;


import java.io.*;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class FileFun implements FileAndPath{

    @Override
    public void hemmingDistance(Path file1, Path file2) {
        int index = 0;
        int hemmingCount = 0;

        while (index < file1.toString().length() && index < file2.toString().length()) {
            if(file1.toString().charAt(index) != file2.toString().charAt(index))
                hemmingCount += 1;
            index +=1;
        }


        hemmingCount += Math.abs(file1.toString().length() - file2.toString().length());
        System.out.println(hemmingCount);

    }

    @Override
    public void convertToLowercase(Path inPath, Path outPath) {

        try (
                FileReader myFileReader = new FileReader(inPath.toString());
                BufferedReader myBufferedReader = new BufferedReader(myFileReader);
                FileWriter myFileWriter = new FileWriter(outPath.toString());
                ) {
            String line = myBufferedReader.readLine();
            String content = null;
            while (line != null) {
                content += line;
                line = myBufferedReader.readLine();
            }
            content = content.toLowerCase();

            myFileWriter.write(content);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void readLineByLine(Path file) {
        try(FileReader myFileReader = new FileReader(file.toFile());
            BufferedReader myBufferedReader = new BufferedReader(myFileReader);
            PrintWriter myWriter = new PrintWriter(System.out);
            ) {

            myWriter.println(myBufferedReader.readLine());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void countWordsOfFile(Path file) {
        try (
                FileReader myReader = new FileReader(file.toString());
                PrintWriter myWriter = new PrintWriter(System.out);){

            int countWords = 0;

            // Restriction only works for ASCII
            int myChar = myReader.read();
            while (myChar != -1) {
                if (countWords == 0)
                    countWords += 1;
                if ((char) myChar == ' ')
                    countWords += 1;
                myChar = myReader.read();
            }

            myWriter.println(countWords);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

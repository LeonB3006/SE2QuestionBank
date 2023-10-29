package exercises.exercise02_input_output;

import java.nio.file.Path;

public interface FileAndPath {

    /***
     * Hemming Distance in number of symbols that are different.
     * This Function recieves two files with identical length and prints the hemming distance.
     * @param file1
     * @param file2
     */
    void hemmingDistance(Path file1, Path file2);

    /***
     * Function should recieve the Paths to two text files, it converts the text of the first file into only lowercase
     * and writes the new text in the second file
     * @param inPath file with original text
     * @param outPath file with only lowercase text
     */
    void convertToLowercase(Path inPath, Path outPath);

    /***
     * Functions reads recieved file line by line, stores it in a variable and prints it.
     * @param file
     */
    void readLineByLine(Path file);

    /***
     * Function recieves the Path of a file, counts its words and prints the count.
     * @param file
     */
    void countWordsOfFile(Path file);

}




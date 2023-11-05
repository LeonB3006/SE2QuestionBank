package exercises.exercise02_input_output;

import java.nio.file.Path;

public class DemoMe {
    public static void main(String[] args) {
        FileFun sut = new FileFun();


        Path p1 = Path.of("/Users/leonbender/IdeaProjects/SE2QuestionBank/src/exercises/exercise02_input_output/hello.txt");
        Path p2 = Path.of("/Users/leonbender/IdeaProjects/SE2QuestionBank/src/exercises/exercise02_input_output/hello_two.txt");

//        sut.convertToLowercase(p1, p2);


//        sut.readLineByLine(p2);

        sut.countWordsOfFile(p2);
    }
}

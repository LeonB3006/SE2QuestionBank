package exercises.exercise02_input_output.WelcomeX;

import java.io.*;

public class MrXWriter extends PrintWriter {


    static private int myCount = 0;

    public MrXWriter(Writer out) {
        super(out);
    }




    @Override
    public void print(char c) {
        if (myCount < 2) {
            myCount +=1;
            super.print(c);
        } else {
            myCount = 0;
        }
    }



}

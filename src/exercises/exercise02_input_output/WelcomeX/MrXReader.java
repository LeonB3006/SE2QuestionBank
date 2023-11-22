package exercises.exercise02_input_output.WelcomeX;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class MrXReader extends FilterReader {

    public MrXReader(Reader in){
        super(in);
    }

    @Override
    public int read() throws IOException {
        return super.read() +10;
    }
}

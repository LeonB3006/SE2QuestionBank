package exercises.exercise02_input_output.WelcomeX;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.stream.Stream;

public class MrXReader extends FilterReader {

    /**
     * Creates a new filtered reader.
     *
     * @param in a Reader object providing the underlying stream.
     * @throws NullPointerException if {@code in} is {@code null}
     */
    public MrXReader(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        return super.read() + 10;

    }



}

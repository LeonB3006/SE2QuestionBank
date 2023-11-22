package exercises.exercise02_input_output.WelcomeX;


import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class MrXWriter extends FilterWriter {

    static int count = 1;

    /**
     * Create a new filtered writer.
     *
     * @param out a Writer object to provide the underlying stream.
     * @throws NullPointerException if {@code out} is {@code null}
     */
    protected MrXWriter(Writer out) {
        super(out);
    }

    public void print(int c) throws IOException {
        if(count%3 != 0) {
            super.write(c);
        }
        count++;
    }
}

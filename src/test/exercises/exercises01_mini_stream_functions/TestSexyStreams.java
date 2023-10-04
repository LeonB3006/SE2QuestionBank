package test.exercises.exercises01_mini_stream_functions;

import exercises.exercise01_mini_stream_functions.SexyStreams;
import exercises.exercise01_mini_stream_functions.streamOrLoop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TestSexyStreams {

    streamOrLoop sut = new SexyStreams();

    @Test
    void testIntAverageBasicTrue() {
        final int result = sut.averageIntOfList(List.of(1,2,2,2,5,6));
        assert result == 3;
    }

    @Test
    void testIntAverageSameTrue() {
        final int result = sut.averageIntOfList(List.of(1,1,1,1));
        assert result == 1;
    }
    @Test
    void testIntAverageNullTrue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            final int result = sut.averageIntOfList(List.of());
        });
    }
}

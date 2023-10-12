package test.exercises.exercises01_mini_stream_functions;

import exercises.exercise01_mini_stream_functions.SexyStreams;
import exercises.exercise01_mini_stream_functions.streamOrLoop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TestSexyStreams {

    /*** Tests for averageIntOfList() ***/

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



    /*** Tests for removeListDuplicates() ***/

    @Test
    void testRemoveListDuplicates() {
        final List<Integer> myList = List.of(1,2,3,3,4,5,7,4,3);
        final List<Integer> resultList = sut.removeListDuplicates(myList);
        assert resultList.equals(List.of(1,2,3,4,5,7));

    }

    @Test
    void testRemoveListDuplicatesNoDuplicates() {
        final List<Integer> myList = List.of(1,2,3,45,67,876);
        final List<Integer> resultList = sut.removeListDuplicates(myList);
        assert resultList.equals(myList);

    }


    @Test
    void testRemoveListDuplicatesEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            final List<Integer> result = sut.removeListDuplicates(List.of());
        });

    }


    /*** Tests for countStringOccurrence() ***/


    @Test
    void countStringOccurrence() {
        final List<String> myList = List.of("Pickles", "pringles", "lays", "pizza", "Leeks");
        final int resultCount = sut.countStringOccurrence(myList, 'p');
        assert resultCount == 3;

    }

    @Test
    void countStringOccurrenceZero() {
        final List<String> myList = List.of("Pickles", "pringles", "lays", "pizza", "Leeks");
        final int resultCount = sut.countStringOccurrence(myList, 'z');
        assert resultCount == 0;

    }

    @Test
    void countStringOccurrenceEmpty() {
        final int resultCount = sut.countStringOccurrence(List.of(), 'c');
        assert resultCount == 0;
    }

}

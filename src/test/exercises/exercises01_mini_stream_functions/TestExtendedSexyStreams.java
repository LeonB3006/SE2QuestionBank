package test.exercises.exercises01_mini_stream_functions;

import exercises.exercise01_mini_stream_functions.ExtendedSexyStreams;
import exercises.exercise01_mini_stream_functions.SexyStreams;
import exercises.exercise01_mini_stream_functions.extendedStreamOrLoop;
import exercises.exercise01_mini_stream_functions.streamOrLoop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class TestExtendedSexyStreams {

    /*** Tests for averageIntOfList() ***/

    extendedStreamOrLoop sut = new ExtendedSexyStreams();

    @Test
    void testProductOfList() {
        Assertions.assertEquals(6, sut.productOfList(Arrays.asList(1, 2, 3)));
        Assertions.assertEquals(0, sut.productOfList(Arrays.asList(0, 1, 2, 3)));
        Assertions.assertEquals(24, sut.productOfList(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    void testSecondHighestNumber() {
        Assertions.assertEquals(Optional.of(2), sut.secondHighestNumber(Arrays.asList(1, 2, 3)));
        Assertions.assertEquals(Optional.of(3), sut.secondHighestNumber(Arrays.asList(3, 3, 3, 4)));
        Assertions.assertEquals(Optional.empty(), sut.secondHighestNumber(Collections.singletonList(1)));
        Assertions.assertEquals(Optional.empty(), sut.secondHighestNumber(Collections.emptyList()));
    }

    @Test
    void testFilterOdds() {
        Assertions.assertEquals(Arrays.asList(1, 3, 5), sut.filterOdds(Arrays.asList(1, 2, 3, 4, 5)));
        Assertions.assertEquals(Collections.emptyList(), sut.filterOdds(Arrays.asList(2, 4, 6, 8)));
    }

    @Test
    void testIsPalindrome() {
        Assertions.assertTrue(sut.isPalindrome(121));
        Assertions.assertTrue(sut.isPalindrome(1331));
        Assertions.assertTrue(sut.isPalindrome(1234554321));
        Assertions.assertFalse(sut.isPalindrome(1234432123));
        Assertions.assertFalse(sut.isPalindrome(123));
        Assertions.assertFalse(sut.isPalindrome(100));
    }

    @Test
    void testMostFrequentNumber() {
        Assertions.assertEquals(Optional.of(3), sut.mostFrequentNumber(Arrays.asList(1, 2, 3, 3, 3, 4, 4)));
        Assertions.assertEquals(Optional.of(2), sut.mostFrequentNumber(Arrays.asList(1, 2, 2, 3, 4)));
        Assertions.assertEquals(Optional.empty(), sut.mostFrequentNumber(Collections.emptyList()));
    }

    @Test
    void testSumOfSquares() {
        Assertions.assertEquals(14, sut.sumOfSquares(Arrays.asList(1, 2, 3)));
        Assertions.assertEquals(0, sut.sumOfSquares(Collections.emptyList()));
        Assertions.assertEquals(1, sut.sumOfSquares(Collections.singletonList(1)));
        Assertions.assertEquals(55, sut.sumOfSquares(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    void testDoubleValues() {
        Assertions.assertEquals(Arrays.asList(2, 4, 6), sut.doubleValues(Arrays.asList(1, 2, 3)));
        Assertions.assertEquals(Collections.emptyList(), sut.doubleValues(Collections.emptyList()));
        Assertions.assertEquals(Collections.singletonList(2), sut.doubleValues(Collections.singletonList(1)));
    }






}

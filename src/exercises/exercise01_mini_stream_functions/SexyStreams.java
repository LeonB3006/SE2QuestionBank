package exercises.exercise01_mini_stream_functions;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

public class SexyStreams implements streamOrLoop {
    /***
     * General Rules:
     * No Arrays unless specified in the function description
     * No Strings unless otherwise specified
     * No Loops
     * Catch and throw Exceptions when suitable
     */


    @Override
    public int averageIntOfList(List<Integer> array) {
        if (array == null || array.isEmpty())
            throw new IllegalArgumentException();
        return array.stream().mapToInt(Integer::intValue).sum() / array.size();

    }

    @Override
    public List<Integer> removeListDuplicates(List<Integer> myNumbers) {
        if (myNumbers == null|| myNumbers.isEmpty())
            throw new IllegalArgumentException();
        return myNumbers.stream().distinct().toList();

    }

    @Override
    public int countStringOccurrence(List<String> myStringSequence, char startLetter) {
        return myStringSequence.stream().map(String::toLowerCase).filter(n -> n.indexOf(Character.toLowerCase(startLetter)) == 0).mapToInt(n -> 1).sum();

    }

    @Override
    public int calculateDigitSum(int myInt) {
        return 0;
    }

    @Override
    public void printAllMultiplications(int myNumber) {
        IntStream.rangeClosed(1, myNumber).forEach(n -> IntStream.rangeClosed(1, myNumber).map(x -> x * n).forEach(System.out::println));

    }

    @Override
    public Optional<List<Integer>> flipList(List<Integer> myList) {
        return Optional.of(myList.stream().sorted((a, b) -> -1).toList());

    }


}

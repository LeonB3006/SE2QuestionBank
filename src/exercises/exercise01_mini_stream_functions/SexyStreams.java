package exercises.exercise01_mini_stream_functions;

import java.util.*;
import java.util.stream.IntStream;

public class SexyStreams implements streamOrLoop{
    /***
     * General Rules:
     * No Arrays unless specified in the function description
     * No Strings unless otherwise specified
     * No Loops
     * Catch and throw Exceptions when suitable
     */


    @Override
    public int averageIntOfList(List<Integer> array) {

        if(array.isEmpty())
            throw new IllegalArgumentException();

        return array.stream().mapToInt(Integer::intValue)
                .average()
                .stream().mapToLong(Math::round).mapToInt(i -> (int) i)
                .findAny().getAsInt();

    }

    @Override
    public List<Integer> removeListDuplicates(List<Integer> myNumbers) {

        if(myNumbers.isEmpty())
            throw new IllegalArgumentException();

        return myNumbers.stream().distinct().toList();
    }

    @Override
    public int countStringOccurrence(List<String> myStringSequence, char startLetter) {
        return (int)myStringSequence.stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith(String.valueOf(startLetter)))
                .count();

    }

    @Override
    public int calculateDigitSum(int myInt) {
        return IntStream.iterate(1, n -> 10*n )
                .takeWhile(n -> n < myInt)
                .map(n-> myInt/n)
                .map(n-> n % 10)
                .sum();

    }

    @Override
    public void printAllMultiplications(int myNumber) {
        IntStream.range(1, myNumber+1)
                .flatMap (x -> IntStream.range(1, myNumber + 1).map(y -> y * x))
                .forEach(System.out::println);
    }

    @Override
    public Optional<List<Integer>> flipList(List<Integer> myList) {
        return Optional.of( myList.stream()
                .sorted((x,y) -> -1) // y immer größer als x -> 1. Element ist das größte -> landet ganz rechts
                .toList());
    }


}

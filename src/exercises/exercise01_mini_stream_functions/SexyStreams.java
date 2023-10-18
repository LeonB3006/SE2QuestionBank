package exercises.exercise01_mini_stream_functions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
        try{
            double answer = array.stream().mapToDouble(Integer::doubleValue).average().orElseThrow(); // kann man das schöner machen?
            return (int)answer;
        }catch (NoSuchElementException e){
            throw new IllegalArgumentException(e);
        }

    }

    @Override
    public List<Integer> removeListDuplicates(List<Integer> myNumbers) {
        if (myNumbers.isEmpty())
            throw new IllegalArgumentException();
        else
            return myNumbers.stream().distinct().toList();

    }

    @Override
    public int countStringOccurrence(List<String> myStringSequence, char startLetter) {
        long number = myStringSequence.stream().filter(n -> n.toLowerCase().charAt(0) == Character.toLowerCase(startLetter)).count(); // Kann man alles in einer zeile machen?
        return (int)number;
    }

    @Override
    public int calculateDigitSum(int myInt) {
         return Arrays.stream(Integer.toString(myInt).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    @Override
    public void printAllMultiplications(int myNumber) {
        Stream.iterate(0, n -> n+1).limit(myNumber).map(n -> n*n).forEach(System.out::println);

    }

    @Override
    public Optional<List<Integer>> flipList(List<Integer> myList) {
        return myList.reversed()
                .stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of));
    }

}

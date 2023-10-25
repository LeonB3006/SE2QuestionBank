package exercises.exercise01_mini_stream_functions;

import java.util.*;
import java.util.stream.IntStream;
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
        return (int) array.stream().mapToDouble(Integer::doubleValue).average().orElse(0);

    }

    @Override
    public List<Integer> removeListDuplicates(List<Integer> myNumbers) {
        return myNumbers.stream().distinct().toList();
    }

    @Override
    public int countStringOccurrence(List<String> myStringSequence, char startLetter) {
        return (int) myStringSequence.stream().filter(str -> str.charAt(0) == startLetter ||str.charAt(0) == String.valueOf(startLetter).toUpperCase().charAt(0)).count();
    }

    @Override
    public int calculateDigitSum(int myInt) {
        return IntStream.iterate(10, i->i * 10).takeWhile(theInt -> theInt < myInt * 10).reduce(0, (prev, curr) -> prev + ((myInt % curr) / (curr / 10)));
    }

    @Override
    public void printAllMultiplications(int myNumber) {
        IntStream.range(1, myNumber +1).flatMap( num ->
                IntStream.range(num, myNumber + 1).filter(currNum -> currNum > num)
                        .peek(currNum -> System.out.println(num + "x" + currNum + "="+num*currNum))
                        .map(currNum -> num*currNum)

        );
    }

    @Override
    public Optional<List<Integer>> flipList(List<Integer> myList) {

//        Comparator<Integer> myReverseCom = (o1, o2) -> o2 - o1;
        return Optional.of(myList.stream().sorted((o1, o2) -> o2 - o1).toList());

    }


}

package exercises.exercise01_mini_stream_functions;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LoserLoops implements streamOrLoop {
    /***
     * Less restrictions, but ateleast try to be elegant
     */
    @Override
    public int averageIntOfList(List<Integer> array) {
        return array.stream().mapToInt(Integer::intValue).sum() / array.size();

    }

    @Override
    public List<Integer> removeListDuplicates(List<Integer> myNumbers) {
        return myNumbers.stream().distinct().toList();
    }

    @Override
    public int countStringOccurrence(List<String> myStringSequence, char startLetter) {
        return myStringSequence.stream().filter(n -> n.indexOf(startLetter) == 0).mapToInt(n -> 1).sum();
    }

    @Override
    public int calculateDigitSum(int myInt) {
        return 0;
    }

    @Override
    public void printAllMultiplications(int myNumber) {
        IntStream.rangeClosed(1, myNumber).forEach(n->IntStream.rangeClosed(1, myNumber).map(x-> x*n).forEach(System.out::println));
    }

    @Override
    public Optional<List<Integer>> flipList(List<Integer> myList) {
        return Optional.of(myList.stream().sorted((a, b) -> -1).toList());
    }

    public static void main(String[] args) {
        LoserLoops loops = new LoserLoops();
        loops.printAllMultiplications(5);
    }
}


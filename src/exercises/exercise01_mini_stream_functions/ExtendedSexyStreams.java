package exercises.exercise01_mini_stream_functions;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtendedSexyStreams implements extendedStreamOrLoop {

    @Override
    public long productOfList(List<Integer> myNumbers) {
        return myNumbers.stream().reduce(1, (a, b) -> (a * b));
    }

    @Override
    public Optional<Integer> secondHighestNumber(List<Integer> myNumbers) {
        return myNumbers.stream().sorted().limit(Integer.max(myNumbers.size() - 1, 0)).max(Integer::compareTo);
    }

    @Override
    public List<Integer> filterOdds(List<Integer> myNumbers) {
        return myNumbers.stream().filter(n -> n % 2 == 1).toList();
    }

    @Override
    public boolean isPalindrome(int number) {
        // Stream.iterate to generate 12345, 1234, 123, 12 und 1.
        return number == Stream.iterate(number, (n -> n > 0), (n -> n / 10))
                .map(n -> n % 10) //get all numbers from back to front
                .reduce(0, (accumulated, digit) -> accumulated * 10 + digit); // glue them back together;

    }

    @Override
    public Optional<Integer> mostFrequentNumber(List<Integer> myNumbers) {
        // Start streaming the list of numbers
        return myNumbers.stream()
                // Group the numbers by their value and count their occurrences
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                // Convert the resulting map into a stream of entries
                .entrySet().stream()
                // Find the entry with the maximum count (i.e., the most frequent number)
                .max(Map.Entry.comparingByValue())
                // Extract the key (the number) from the entry with the maximum count
                .map(Map.Entry::getKey);
    }


    @Override
    public long sumOfSquares(List<Integer> myNumbers) {
        return myNumbers.stream().mapToInt(n -> n*n).sum();
    }

    @Override
    public List<Integer> doubleValues(List<Integer> myNumbers) {
        return myNumbers.stream().map(n->n*2).toList();
    }

    public static void main(String[] args) {
        ExtendedSexyStreams extendedSexyStreams = new ExtendedSexyStreams();
        extendedSexyStreams.isPalindrome(12345);
    }
}


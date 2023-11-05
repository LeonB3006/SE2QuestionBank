package exercises.exercise01_mini_stream_functions;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExtendedSexyStreams implements extendedStreamOrLoop{

    @Override
    public long productOfList(List<Integer> myNumbers) {
        return myNumbers.stream().reduce((a,b) -> a*b).get();
    }

    @Override
    public Optional<Integer> secondHighestNumber(List<Integer> myNumbers) {

        List<Integer> myInteger = myNumbers.stream().sorted(Integer::compareTo).skip(Math.abs(myNumbers.size()-2)).toList();
        return myInteger.size() > 1 ? Optional.of(myInteger.get(myInteger.size() -2)) : Optional.empty();
    }

    @Override
    public List<Integer> filterOdds(List<Integer> myNumbers) {
        return myNumbers.stream().filter(num -> num%2 != 0).toList();
    }

    @Override
    public boolean isPalindrome(int number) {
        return false;
    }

    @Override
    public Optional<Integer> mostFrequentNumber(List<Integer> myNumbers) {
        myNumbers.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        return Optional.empty();
    }

    @Override
    public long sumOfSquares(List<Integer> myNumbers) {

        return 0;
    }

    @Override
    public List<Integer> doubleValues(List<Integer> myNumbers) {
        return null;
    }
}

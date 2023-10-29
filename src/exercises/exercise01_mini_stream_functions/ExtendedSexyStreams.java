package exercises.exercise01_mini_stream_functions;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class ExtendedSexyStreams implements extendedStreamOrLoop{

    @Override
    public long productOfList(List<Integer> myNumbers) {
        return myNumbers.stream()
                .mapToInt(Integer::intValue)
                .reduce(1, (a,b) -> a*b);
    }

    @Override
    public Optional<Integer> secondHighestNumber(List<Integer> myNumbers) {
        return myNumbers.stream()
                .sorted()
                .limit(myNumbers.size()>1 ? myNumbers.size()-1: 0)
                .sorted((x,y) -> -1)
                .limit(1)
                .findAny();
  /*schöner mit max:
        return myNumbers.stream()
                .sorted()
                .limit(myNumbers.size()>1 ? myNumbers.size()-1: 0)
                .max(Integer::compareTo);*/
    }

    @Override
    public List<Integer> filterOdds(List<Integer> myNumbers) {
        return myNumbers.stream()
                .filter(x -> x%2 == 1)
                .toList();


    }

    @Override
    public boolean isPalindrome(int number) {
        return number == Stream.iterate(1,n -> 10*n)
                .takeWhile(n -> n< number)
                .map(n-> number/n)
                .map(n -> n%10)
                .sorted((a, b)-> -1)
                .reduce(0, (x,y) -> x*10 +y); // funktioniert nicht
    }

    @Override
    public Optional<Integer> mostFrequentNumber(List<Integer> myNumbers) {
        myNumbers.stream()
                .sorted()
                .distinct()
                .map(x -> myNumbers.stream().sorted().map(y -> x.equals(y)? 1: 0) );
        return Optional.empty();
    }

    @Override
    public long sumOfSquares(List<Integer> myNumbers) {

        return (long)myNumbers.stream()
                .mapToInt(x -> x*x)
                .sum();
    }

    @Override
    public List<Integer> doubleValues(List<Integer> myNumbers) {

        return myNumbers.stream()
                .map(x -> x*2)
                .toList();
    }
}

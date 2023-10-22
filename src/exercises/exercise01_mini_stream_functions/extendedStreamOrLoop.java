package exercises.exercise01_mini_stream_functions;

import java.util.List;
import java.util.Optional;

public interface extendedStreamOrLoop {

    /***
     * Function should receive a list of numbers and return the product of all elements.
     */
    long productOfList(List<Integer> myNumbers);

    /***
     * Function should receive a list of numbers and return the second-highest number in the list.
     * If there is no second-highest number, return an empty Optional.
     */
    Optional<Integer> secondHighestNumber(List<Integer> myNumbers);

    /***
     * Function should receive a list of numbers and return a new list containing only odd numbers from the original list.
     */
    List<Integer> filterOdds(List<Integer> myNumbers);

    /***
     * Function should receive an Int and check if the number is a palindrome (e.g., 121, 1331).
     */
    boolean isPalindrome(int number);

    /***
     * Function should receive a list of numbers and return the number that appears the most times in the list.
     * If there are multiple numbers that appear the same maximum number of times, return any one of them.
     * If the list is empty, return an empty Optional.
     */
    Optional<Integer> mostFrequentNumber(List<Integer> myNumbers);

    /***
     * Function should receive a list of numbers and return the sum of the squared values of all the numbers.
     */
    long sumOfSquares(List<Integer> myNumbers);

    /***
     * Function should receive a list of numbers and return a list with the values doubled.
     */
    List<Integer> doubleValues(List<Integer> myNumbers);
}
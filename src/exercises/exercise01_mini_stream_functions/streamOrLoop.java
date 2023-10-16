package exercises.exercise01_mini_stream_functions;

import java.util.List;
import java.util.Optional;

public interface streamOrLoop {
    /***
     * Function should receive a collection of type list<Integer>, then return the average integer
     ***/
    int averageIntOfList(List<Integer> array);

    /***
     * Function should receive a list of numbers, then remove any Duplicate entries
     */
    List<Integer> removeListDuplicates(List<Integer> myNumbers);

    /***
     * Function should receive list of strings and count the number starting with startLetter.
     * UpperCase & Lowercase should not be differentiated.
     * Empty Lists are allowed
     */
    int countStringOccurrence(List<String> myStringSequence, char startLetter);


    /***
     * Function should receive an Int and provide the Digit Sum Eg 1223 -> 8
     */
    int calculateDigitSum(int myInt);


    /***
     * This functions receives an Int n, and returns all values 1*1, 1*2, 1*3.... 1*n, then 2*2, 2*3... until the final digit n*n is printed
     * (Currently no unit Tests)
     */
    void printAllMultiplications(int myNumber);


    /***
     * This function receives a List and reverses its order. Eg [1,3,3,4] -> [4,3,3,1]
     * @param myList
     * @return
     */
    Optional<List<Integer>> flipList(List<Integer> myList);


}

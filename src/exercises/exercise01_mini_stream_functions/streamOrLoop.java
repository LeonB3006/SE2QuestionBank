package exercises.exercise01_mini_stream_functions;

import java.util.List;

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
     * Function should receive list of strings and count the number starting with startLetter
     */
    int countStringOccurrence(List<String> myStringSequence, char startLetter);

}

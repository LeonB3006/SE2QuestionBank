package exercises.PastPaper.SS23.Q2;

import java.util.HashMap;
import java.util.Map;


/***
 * Convert the two Functions PerformPolymerization and quantityMap into stream functions
 */
public class Polymere {


    public String description;

    public Polymere(String description) {
        description = description;
    }

    public Polymere performPolymerization(Map<String, String> rules) {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < description.length() - 1; index++) {
            var pair = description.substring(index, index + 2);
            result.append(pair.charAt(0)).append(rules.getOrDefault(pair, ""));
        }
        result.append(description.charAt(description.length() - 1));
        return new Polymere(result.toString());
    }

    Map<Integer, Integer> quantityMap() {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int index = 0; index < this.description.length(); index++) {
            frequencyMap.merge((int)description.charAt(index), 1, Integer::sum);
        }
        return frequencyMap;
    }

}

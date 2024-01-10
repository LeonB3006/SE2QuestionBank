package exercises.exercise03_collection_framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public record Josephus(List<String> prisoners) {
    //  private final List<String> internalList;

    public Josephus(List<String> prisoners) {
        if (prisoners == null) throw new NullPointerException();

        this.prisoners = new ArrayList<>(prisoners);

    }

    public List<String> hailTheKing(int badNumber, int happy) {
        if (badNumber < 1 || happy < 1) throw new IllegalArgumentException();

        final List<String> line = new ArrayList<>(prisoners);
        int saidNumber = 0;
        int peopleLeft = line.size();

        while (peopleLeft > happy) {
            //execute logic
            Iterator<String> iterator = line.iterator();
            while (iterator.hasNext()) {
                if (peopleLeft <= happy) {
                    return line;
                }

                iterator.next();
                saidNumber++;

                if (saidNumber == badNumber) {
                    iterator.remove();
                    saidNumber = 0;
                }
                peopleLeft = line.size();
            }
        }
        return line;
    }

    @Override
    public List<String> prisoners() {
        return prisoners;
    }
}
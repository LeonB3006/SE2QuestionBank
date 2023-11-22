package exercises.exercise03_collection_framework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record Josephus(List<String> prisoners) {

    public Josephus(List<String> prisoners) {
        Objects.requireNonNull(prisoners);
        this.prisoners = new ArrayList<>(prisoners);
    }

    public List<String> hailTheKing(int bad, int happy) {
        if (bad < 1 || happy < 1)
            throw new IllegalArgumentException();
        int currentNumber = 0;
        int unluckyNumber = 1;
        List<String> happyPrisoners = new ArrayList<>(prisoners());

        while(happyPrisoners.size() > happy){

            if (unluckyNumber%bad == 0){
                happyPrisoners.remove(currentNumber);
                unluckyNumber = 1;
            } else
                if(currentNumber >= happyPrisoners.size()-1){
                   if (unluckyNumber !=1)
                       unluckyNumber++;
                    currentNumber = 0 ;
                } else{
                    currentNumber++;
                    unluckyNumber++;
                }
        }
        return happyPrisoners;
    }

    @Override
    public List<String> prisoners() {
        return prisoners;
    }
}
package exercises.exercise03_collection_framework;

import java.util.List;

public record Josephus(List<String> prisoners) {
    public Josephus(List<String> prisoners) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public List<String> hailTheKing(int bad, int happy) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override
    public List<String> prisoners() {
        throw new UnsupportedOperationException("Not implemented.");
    }
}
package exercises.exercise03_collection_framework;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TheThinLine<T> implements ThinLine<T> {
    private final T defaultValue;

    //private final ArrayList<Map<Integer, T>> internalList = new ArrayList<>();
    private final Map<Integer, T> internalList = new HashMap<>();

    public TheThinLine() {
        defaultValue = null;
    }

    public TheThinLine(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public void replace(int index, T value) {
        if (index < 0) throw new IllegalArgumentException();

        if(value.equals(defaultValue)) {
            internalList.remove(index);
            return;
        };

        internalList.put(index, value);
    }

    @Override
    public void insert(int index, T value) {
        if (index < 0) throw new IllegalArgumentException();

        if(value.equals(defaultValue)) return;

        internalList.put(index, value);

    }

    @Override
    public T read(int index) {
        if (index < 0) throw new IllegalArgumentException();


        T value = internalList.getOrDefault(index, defaultValue);

        return value;


    }

    @Override
    public T delete(int index) {
        if (index < 0) throw new IllegalArgumentException();

        internalList.remove(index);

        return null;
    }

    @Override
    public int lastAt() {
        if (internalList.size()<1) return -1;
        int value = Collections.max(internalList.entrySet(), Map.Entry.comparingByKey()).getKey();


        return value;
    }
}

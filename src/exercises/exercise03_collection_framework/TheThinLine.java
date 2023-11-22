package exercises.exercise03_collection_framework;

import java.util.*;

public class TheThinLine<T> extends AbstractMap<Integer, T> implements ThinLine<T> {
    private final T defaultValue;
    private final Map<Integer, T> delegate;

    public TheThinLine() {
        this( null);
    }


    public TheThinLine(T defaultValue) {
        this.defaultValue = defaultValue;
        delegate = new HashMap<>();

    }

    @Override
    public void replace(int index, T value) {
        if (index < 0 )
            throw new IllegalArgumentException();
      delegate.put(index, value);
    }

    @Override
    public void insert(int index, T value) {
        if (index < 0 )
            throw new IllegalArgumentException();
        final Set<Integer> keys = delegate.keySet();
        final List<Integer> sortedKeys = keys.stream().sorted().sorted((x,y) -> -1).toList();
        for (int key : sortedKeys) {
            if (key >= index) {
                delegate.put(key +1, read(key));
            }
        }
        delegate.put(index, value); // oder replace
    }

    @Override
    public T read(int index) {
        if (index < 0 )
            throw new IllegalArgumentException();
        return delegate.getOrDefault(index, defaultValue);
    }

    @Override
    public T delete(int index) {
        if (index < 0 )
            throw new IllegalArgumentException();

        final T removed = read(index);
        replace(index, defaultValue);
        final Set<Integer> keys = delegate.keySet();
        final List<Integer> sortedKeys = keys.stream().sorted().toList();
        for (int key : sortedKeys){
            if(key > index){
                delegate.put(key - 1, read(key));
                if (key == lastAt()){
                    delegate.put(key, defaultValue);
                }


            }
        }
        //delegate.put(lastAt(), defaultValue);
        //delegate.put(sortedKeys.get(0), defaultValue);
        return removed;
    }

    @Override
    public int lastAt() {
        int lastElement = -1;
        final Set<Integer> keys = delegate.keySet();
        final List<Integer> sortedKeys = keys.stream().sorted().toList();
        for (int key : sortedKeys){
            if (!delegate.get(key).equals(defaultValue))
                lastElement = key;
        }
        return lastElement;
    }

    @Override
    public Set<Entry<Integer, T>> entrySet() {
        return new HashSet<>();
    }
}

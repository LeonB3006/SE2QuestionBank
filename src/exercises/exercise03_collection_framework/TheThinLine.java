package exercises.exercise03_collection_framework;

public class TheThinLine<T> implements ThinLine<T> {
    public TheThinLine() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public TheThinLine(T defaultValue) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override
    public void replace(int index, T value) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override
    public void insert(int index, T value) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override
    public T read(int index) {
        return null;
    }

    @Override
    public T delete(int index) {
        return null;
    }

    @Override
    public int lastAt() {
        return 0;
    }
}

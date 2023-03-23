package ua.dpw.database;

public class Parameter<T> {

    private T value;

    public Parameter(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
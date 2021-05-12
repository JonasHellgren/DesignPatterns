package org.example.generics;

public class GenericClass<T> {

    private T t;

    public GenericClass(T t) {
        this.t = t;
    }

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
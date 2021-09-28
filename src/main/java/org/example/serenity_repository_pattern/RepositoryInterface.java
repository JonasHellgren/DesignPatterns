package org.example.serenity_repository_pattern;

import java.util.List;

public interface RepositoryInterface<T> {
    void add(T t);
    List<T> getAll();
    List<T> findBySpecification(SpecificationInterface specification);
    void update(T oldT, T newT);
    void remove(long id);
}
package org.example.dao_pattern_baeldung;

import java.util.List;
import java.util.Optional;

/***
 * abstract API that performs CRUD operations on objects of type T.
 */

public interface  StorageInterface<T> {
    Optional<T> get(long id);
    List<T> getAll();
    void save(T t);
    void update(String userName, T replacingUser);
    void delete(T t);
}

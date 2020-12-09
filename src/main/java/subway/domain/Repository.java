package subway.domain;

import java.util.List;

public interface Repository<T, ID> {
    default List<T> findAll() {
        throw new UnsupportedOperationException();
    }

    default void save(T entity) {
        throw new UnsupportedOperationException();
    }

    default boolean delete(ID id) {
        throw new UnsupportedOperationException();
    }
}

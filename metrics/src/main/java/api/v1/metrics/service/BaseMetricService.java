package api.v1.metrics.service;

import java.util.List;

public interface BaseMetricService<T> {
    void save(T item);

    void delete(Long id);

    List<T> getAll();
}

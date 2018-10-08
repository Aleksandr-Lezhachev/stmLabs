package api.v1.metrics.service;

import api.v1.metrics.entity.CpuMetric;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BaseMetricService<T> {
    void save(T item);

    void delete(Long id);

    List<T> getAll();

    List<T> getByNameSomeMetrics(String name,Integer size);
}


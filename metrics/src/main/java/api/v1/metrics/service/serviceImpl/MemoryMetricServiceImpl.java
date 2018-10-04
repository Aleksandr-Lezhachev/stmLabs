package api.v1.metrics.service.serviceImpl;

import api.v1.metrics.entity.MemoryMetric;
import api.v1.metrics.service.MemoryMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryMetricServiceImpl implements MemoryMetricService {
    @Override
    public void save(MemoryMetric item) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<MemoryMetric> getAll() {
        return null;
    }
}

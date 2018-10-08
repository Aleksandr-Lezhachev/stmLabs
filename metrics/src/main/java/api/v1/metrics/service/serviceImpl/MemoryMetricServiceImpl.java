package api.v1.metrics.service.serviceImpl;

import api.v1.metrics.entity.MemoryMetric;
import api.v1.metrics.repository.MemoryRepository;
import api.v1.metrics.service.MemoryMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryMetricServiceImpl implements MemoryMetricService {
    private final MemoryRepository memoryRepository;

    public MemoryMetricServiceImpl(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    @Override
    public void save(MemoryMetric memoryMetric) {
            memoryRepository.save(memoryMetric);
    }

    @Override
    public void delete(Long id) {
        memoryRepository.deleteById(id);
    }

    @Override
    public List<MemoryMetric> getAll() {
        return memoryRepository.findAll();
    }

    @Override
    public List<MemoryMetric> getByNameSomeMetrics(String name, Integer size) {
        return  memoryRepository.getByNameSomeMetrics(name,size);
    }
}

package api.v1.metrics.service.serviceImpl;

import api.v1.metrics.entity.SsdMetric;
import api.v1.metrics.repository.SsdRepository;
import api.v1.metrics.service.SsdMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SsdMetricServiceImpl implements SsdMetricService {
    private final SsdRepository ssdRepository;

    public SsdMetricServiceImpl(SsdRepository ssdRepository) {
        this.ssdRepository = ssdRepository;
    }

    @Override
    public void save(SsdMetric ssdMetric) {
        ssdRepository.save(ssdMetric);
    }

    @Override
    public void delete(Long id) {
        ssdRepository.deleteById(id);
    }

    @Override
    public List<SsdMetric> getAll() {
        return ssdRepository.findAll();
    }

    @Override
    public List<SsdMetric> getByNameSomeMetrics(String name, Integer size) {
        return ssdRepository.getByNameSomeMetrics(name, size);
    }
}

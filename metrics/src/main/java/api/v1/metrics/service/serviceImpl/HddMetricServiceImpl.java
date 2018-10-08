package api.v1.metrics.service.serviceImpl;

import api.v1.metrics.entity.HddMetric;
import api.v1.metrics.repository.HddRepository;
import api.v1.metrics.service.HddMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HddMetricServiceImpl implements HddMetricService {

    private final HddRepository hddRepository;

    public HddMetricServiceImpl(HddRepository hddRepository) {
        this.hddRepository = hddRepository;
    }

    @Override
    public void save(HddMetric item) {
        hddRepository.save(item);
    }

    @Override
    public void delete(Long id) {
        hddRepository.deleteById(id);
    }

    @Override
    public List<HddMetric> getAll() {
        return hddRepository.findAll();
    }

    @Override
    public List<HddMetric> getByNameSomeMetrics(String name, Integer size) {
        return hddRepository.getByNameSomeMetrics(name, size);
    }
}

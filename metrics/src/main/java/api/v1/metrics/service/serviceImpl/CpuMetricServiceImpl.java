package api.v1.metrics.service.serviceImpl;

import api.v1.metrics.entity.CpuMetric;
import api.v1.metrics.repository.CpuRepository;
import api.v1.metrics.service.CpuMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CpuMetricServiceImpl implements CpuMetricService {
    //@Autowired устарел
    private final CpuRepository cpuRepository;

    public CpuMetricServiceImpl(CpuRepository cpuRepository) {
        this.cpuRepository = cpuRepository;
    }

    @Override
    public void save(CpuMetric cpuMetric) {
        cpuRepository.save(cpuMetric);
    }

    @Override
    public void delete(Long id) {
        cpuRepository.deleteById(id);
    }

    @Override
    public List<CpuMetric> getAll() {
        return cpuRepository.findAll();
    }

    public List<CpuMetric> getSomeMetrics() {
        return cpuRepository.
    }
}

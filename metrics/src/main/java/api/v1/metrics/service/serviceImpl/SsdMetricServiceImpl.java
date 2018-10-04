package api.v1.metrics.service.serviceImpl;

import api.v1.metrics.entity.SsdMetric;
import api.v1.metrics.service.SsdMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SsdMetricServiceImpl implements SsdMetricService {
    @Override
    public void save(SsdMetric item) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<SsdMetric> getAll() {
        return null;
    }
}

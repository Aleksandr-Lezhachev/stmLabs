package api.v1.metrics.service.serviceImpl;

import api.v1.metrics.entity.TaskMetric;
import api.v1.metrics.service.TaskMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskMetricServiceImpl implements TaskMetricService {
    @Override
    public void save(TaskMetric item) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<TaskMetric> getAll() {
        return null;
    }
}

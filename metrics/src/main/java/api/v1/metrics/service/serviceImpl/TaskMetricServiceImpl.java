package api.v1.metrics.service.serviceImpl;

import api.v1.metrics.entity.TaskMetric;
import api.v1.metrics.repository.TaskRepository;
import api.v1.metrics.service.TaskMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskMetricServiceImpl implements TaskMetricService {
    private final TaskRepository taskRepository;

    public TaskMetricServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void save(TaskMetric taskMetric) {
        taskRepository.save(taskMetric);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskMetric> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<TaskMetric> getByNameSomeMetrics(String name, Integer size) {
        return taskRepository.getByNameSomeMetrics(name, size);
    }
}

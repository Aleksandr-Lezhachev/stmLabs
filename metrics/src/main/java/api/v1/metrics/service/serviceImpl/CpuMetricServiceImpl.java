package api.v1.metrics.service.serviceImpl;

import api.v1.metrics.entity.CpuMetric;
import api.v1.metrics.repository.CpuRepository;
import api.v1.metrics.service.CpuMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CpuMetricServiceImpl implements CpuMetricService {

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

    @Override
    public List<CpuMetric> getByNameSomeMetrics(String name, Integer size) {
        return cpuRepository.getByNameSomeMetrics(name.toLowerCase(), size);
    }

  /*  public List<Object[]> TestMethod() {
        EntityManager em = null;
       Query query = (Query) em.createNativeQuery("SELECT attributes.name, cpu_metrics.id, cpu_metrics.attribute_id ,attributes.value, cpu_metrics.param,attributes.timestamp, attributes.requesttimestamp " +
               "FROM cpu_metrics INNER JOIN attributes " +
               "ON cpu_metrics.attribute_id = attributes.id  " +
               "WHERE attributes.name = (:name) " +
               "ORDER BY attributes.timestamp " +
               "DESC LIMIT NULLIF(:size, -1)", "CustomResult");


    }*/
}

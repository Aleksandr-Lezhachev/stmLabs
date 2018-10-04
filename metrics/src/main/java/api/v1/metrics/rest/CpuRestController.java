package api.v1.metrics.rest;

import api.v1.metrics.entity.CpuMetric;
import api.v1.metrics.service.CpuMetricService;
import org.hibernate.criterion.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class CpuRestController {
    // @Autowired устраел
    private final CpuMetricService cpuMetricService;


    public CpuRestController(CpuMetricService cpuMetricService) {
        this.cpuMetricService = cpuMetricService;
    }

    @GetMapping("/get/cpu/all")
    public ResponseEntity<List<CpuMetric>> getListCpuMetrics() {
        List<CpuMetric> cpuMetricList = this.cpuMetricService.getAll();
        if (cpuMetricList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cpuMetricList, HttpStatus.OK);
    }

    @GetMapping("/get/cpu/{count}")
    public ResponseEntity<List<CpuMetric>> getListCountCpuMetrics() {
        List<CpuMetric> cpuMetricList = this.cpuMetricService.getAll();
        if (cpuMetricList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cpuMetricList, HttpStatus.OK);
    }
}

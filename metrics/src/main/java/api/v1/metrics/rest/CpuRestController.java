package api.v1.metrics.rest;

import api.v1.metrics.entity.CpuMetric;
import api.v1.metrics.service.CpuMetricService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/metrics")
public class CpuRestController {

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

    @GetMapping("/get/{name}/{count}")
    public ResponseEntity<List<CpuMetric>> getListCountCpuMetrics(@PathVariable("name") String name, @PathVariable("count") int size) {
        List<CpuMetric> cpuMetricList = this.cpuMetricService.getByNameSomeMetrics(name, size);
        if (cpuMetricList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cpuMetricList, HttpStatus.OK);
    }

    @PostMapping("/post/cpu")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCpuMetric(@RequestBody CpuMetric cpuMetric) {
        cpuMetricService.save(cpuMetric);
    }

}

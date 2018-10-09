package api.v1.metrics.rest;


import api.v1.metrics.entity.*;
import api.v1.metrics.repository.TaskRepository;
import api.v1.metrics.service.*;
import api.v1.metrics.wrapper.WrapperMetrics;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/v1/metrics")
public class MainRestController {
    private final CpuMetricService cpuMetricService;
    private final HddMetricService hddMetricService;
    private final MemoryMetricService memoryMetricService;
    private final SsdMetricService ssdMetricService;
    private final TaskMetricService taskMetricService;
    private final TaskRepository taskRepository;

    public MainRestController(CpuMetricService cpuMetricService, HddMetricService hddMetricService, MemoryMetricService memoryMetricService, SsdMetricService ssdMetricService, TaskMetricService taskMetricService, TaskRepository taskRepository) {
        this.cpuMetricService = cpuMetricService;
        this.hddMetricService = hddMetricService;
        this.memoryMetricService = memoryMetricService;
        this.ssdMetricService = ssdMetricService;
        this.taskMetricService = taskMetricService;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/get/all")
    public ResponseEntity getListMetrics() {
        List<BaseMetric> metricList = new ArrayList<BaseMetric>();
        List<CpuMetric> cpuMetricList = this.cpuMetricService.getAll();
        List<HddMetric> hddMetricList = this.hddMetricService.getAll();
        List<MemoryMetric> memoryMetricList = this.memoryMetricService.getAll();
        List<SsdMetric> ssdMetricList = this.ssdMetricService.getAll();
        List<TaskMetric> taskMetricList = this.taskRepository.getAllTask();
        metricList.addAll(cpuMetricList);
        metricList.addAll(hddMetricList);
        metricList.addAll(memoryMetricList);
        metricList.addAll(ssdMetricList);
        metricList.addAll(taskMetricList);
        if (metricList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(metricList, HttpStatus.OK);
    }

    @GetMapping("/get/{name}/{count}")
    public ResponseEntity getCurrentMetric(@PathVariable("name") String name, @PathVariable("count") int size) {
        switch (name.toLowerCase()) {
            case "cpu":
                List<CpuMetric> cpuMetricList = this.cpuMetricService.getByNameSomeMetrics(name, size);
                if (cpuMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(cpuMetricList, HttpStatus.OK);
            case "hdd":
                List<HddMetric> hddMetricList = this.hddMetricService.getByNameSomeMetrics(name, size);
                if (hddMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(hddMetricList, HttpStatus.OK);
            case "memory":
                List<MemoryMetric> memoryMetricList = this.memoryMetricService.getByNameSomeMetrics(name, size);
                if (memoryMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(memoryMetricList, HttpStatus.OK);
            case "ssd":
                List<SsdMetric> ssdMetricList = this.ssdMetricService.getByNameSomeMetrics(name, size);
                if (ssdMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(ssdMetricList, HttpStatus.OK);
            case "task":
                List<TaskMetric> taskMetricList = this.taskMetricService.getByNameSomeMetrics(name, size);
                if (taskMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(taskMetricList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get/{name}/all")
    public ResponseEntity getCurrentMetric(@PathVariable("name") String name) {
        switch (name.toLowerCase()) {
            case "cpu":
                List<CpuMetric> cpuMetricList = this.cpuMetricService.getAll();
                if (cpuMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(cpuMetricList, HttpStatus.OK);
            case "hdd":
                List<HddMetric> hddMetricList = this.hddMetricService.getAll();
                if (hddMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(hddMetricList, HttpStatus.OK);
            case "memory":
                List<MemoryMetric> memoryMetricList = this.memoryMetricService.getAll();
                if (memoryMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(memoryMetricList, HttpStatus.OK);
            case "ssd":
                List<SsdMetric> ssdMetricList = this.ssdMetricService.getAll();
                if (ssdMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(ssdMetricList, HttpStatus.OK);
            case "task":
                List<TaskMetric> taskMetricList = this.taskMetricService.getAll();
                if (taskMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(taskMetricList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/post/")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMetrics(@RequestBody List<WrapperMetrics> metrics) {
        for (WrapperMetrics m : metrics) {
            if (m.getAttribute_id().getName().equals("cpu")) {
                CpuMetric cpu = new CpuMetric(m.getParam(), m.getAttribute_id());
                cpuMetricService.save(cpu);
            }
            if (m.getAttribute_id().getName().equals("hdd")) {
                HddMetric hdd = new HddMetric(m.getParam(), m.getAttribute_id());
                hddMetricService.save(hdd);
            }
            if (m.getAttribute_id().getName().equals("memory")) {
                MemoryMetric memory = new MemoryMetric(m.getParam(), m.getAttribute_id());
                memoryMetricService.save(memory);
            }
            if (m.getAttribute_id().getName().equals("ssd")) {
                SsdMetric ssd = new SsdMetric(m.getParam(), m.getAttribute_id());
                ssdMetricService.save(ssd);
            }
            if (m.getAttribute_id().getName().equals("task")) {
                TaskMetric task = new TaskMetric(m.getAttribute_id());
                taskMetricService.save(task);
            }
        }

    }
}







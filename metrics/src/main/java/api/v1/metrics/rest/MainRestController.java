package api.v1.metrics.rest;


import api.v1.metrics.dto.*;
import api.v1.metrics.entity.*;
import api.v1.metrics.service.*;
import api.v1.metrics.wrapper.ObjectMapperUtils;
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

    public MainRestController(CpuMetricService cpuMetricService, HddMetricService hddMetricService, MemoryMetricService memoryMetricService, SsdMetricService ssdMetricService, TaskMetricService taskMetricService) {
        this.cpuMetricService = cpuMetricService;
        this.hddMetricService = hddMetricService;
        this.memoryMetricService = memoryMetricService;
        this.ssdMetricService = ssdMetricService;
        this.taskMetricService = taskMetricService;
    }

    @GetMapping("/get/all")
    public ResponseEntity getListMetrics() {
        List<BaseMetricDTO> metricList = new ArrayList<>();
        List<CpuMetricDTO> cpuMetricList = ObjectMapperUtils.mapAll(this.cpuMetricService.getByNameSomeMetrics("cpu"), CpuMetricDTO.class);
        List<HddMetricDTO> hddMetricList = ObjectMapperUtils.mapAll(this.hddMetricService.getByNameSomeMetrics("hdd"), HddMetricDTO.class);
        List<MemoryMetricDTO> memoryMetricList = ObjectMapperUtils.mapAll(this.memoryMetricService.getByNameSomeMetrics("memory"), MemoryMetricDTO.class);
        List<SsdMetricDTO> ssdMetricList = ObjectMapperUtils.mapAll(this.ssdMetricService.getByNameSomeMetrics("ssd"), SsdMetricDTO.class);
        List<TaskMetricDTO> taskMetricList = ObjectMapperUtils.mapAll(this.taskMetricService.getByNameSomeMetrics("taskCount"), TaskMetricDTO.class);
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

    @GetMapping("/get")
    public ResponseEntity badRequest() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity getDefaultCurrentMetric(@PathVariable("name") String name) {
        switch (name) {
            case "cpu":
                List<CpuMetricDTO> cpuMetricList = ObjectMapperUtils.mapAll(this.cpuMetricService.getByNameSomeMetrics(name), CpuMetricDTO.class);
                if (cpuMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(cpuMetricList, HttpStatus.OK);
            case "hdd":
                List<HddMetricDTO> hddMetricList = ObjectMapperUtils.mapAll(this.hddMetricService.getByNameSomeMetrics(name), HddMetricDTO.class);
                if (hddMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(hddMetricList, HttpStatus.OK);
            case "memory":
                List<MemoryMetricDTO> memoryMetricList = ObjectMapperUtils.mapAll(this.memoryMetricService.getByNameSomeMetrics(name), MemoryMetricDTO.class);
                if (memoryMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(memoryMetricList, HttpStatus.OK);
            case "ssd":
                List<SsdMetricDTO> ssdMetricList = ObjectMapperUtils.mapAll(this.ssdMetricService.getByNameSomeMetrics(name), SsdMetricDTO.class);
                if (ssdMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(ssdMetricList, HttpStatus.OK);
            case "taskCount":
                List<TaskMetricDTO> taskMetricList = ObjectMapperUtils.mapAll(this.taskMetricService.getByNameSomeMetrics(name), TaskMetricDTO.class);
                if (taskMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(taskMetricList, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get/{name}/{count}")
    public ResponseEntity getCurrentMetric(@PathVariable("name") String name, @PathVariable("count") int size) {
        switch (name) {
            case "cpu":
                List<CpuMetricDTO> cpuMetricList = ObjectMapperUtils.mapAll(this.cpuMetricService.getByNameSomeMetrics(name, size), CpuMetricDTO.class);
                if (cpuMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(cpuMetricList, HttpStatus.OK);
            case "hdd":
                List<HddMetricDTO> hddMetricList = ObjectMapperUtils.mapAll(this.hddMetricService.getByNameSomeMetrics(name, size), HddMetricDTO.class);
                if (hddMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(hddMetricList, HttpStatus.OK);
            case "memory":
                List<MemoryMetricDTO> memoryMetricList = ObjectMapperUtils.mapAll(this.memoryMetricService.getByNameSomeMetrics(name, size), MemoryMetricDTO.class);
                if (memoryMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(memoryMetricList, HttpStatus.OK);
            case "ssd":
                List<SsdMetricDTO> ssdMetricList = ObjectMapperUtils.mapAll(this.ssdMetricService.getByNameSomeMetrics(name, size), SsdMetricDTO.class);
                if (ssdMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(ssdMetricList, HttpStatus.OK);
            case "taskCount":
                List<TaskMetricDTO> taskMetricList = ObjectMapperUtils.mapAll(this.taskMetricService.getByNameSomeMetrics(name, size), TaskMetricDTO.class);
                if (taskMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(taskMetricList, HttpStatus.OK);
            case "all":
                List<BaseMetricDTO> metricList = new ArrayList<>();
                List<CpuMetricDTO> cpuList = ObjectMapperUtils.mapAll(this.cpuMetricService.getByNameSomeMetrics("cpu", size), CpuMetricDTO.class);
                List<HddMetricDTO> hddList = ObjectMapperUtils.mapAll(this.hddMetricService.getByNameSomeMetrics("hdd", size), HddMetricDTO.class);
                List<MemoryMetricDTO> memoryList = ObjectMapperUtils.mapAll(this.memoryMetricService.getByNameSomeMetrics("memory", size), MemoryMetricDTO.class);
                List<SsdMetricDTO> ssdList = ObjectMapperUtils.mapAll(this.ssdMetricService.getByNameSomeMetrics("ssd", size), SsdMetricDTO.class);
                List<TaskMetricDTO> taskList = ObjectMapperUtils.mapAll(this.taskMetricService.getByNameSomeMetrics("taskCount", size), TaskMetricDTO.class);
                metricList.addAll(cpuList);
                metricList.addAll(hddList);
                metricList.addAll(memoryList);
                metricList.addAll(ssdList);
                metricList.addAll(taskList);
                if (metricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(metricList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get/{name}/all")
    public ResponseEntity getAllCurrentMetric(@PathVariable("name") String name) {
        switch (name) {
            case "cpu":
                List<CpuMetricDTO> cpuMetricList = ObjectMapperUtils.mapAll(this.cpuMetricService.getAll(), CpuMetricDTO.class);
                if (cpuMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(cpuMetricList, HttpStatus.OK);
            case "hdd":
                List<HddMetricDTO> hddMetricList = ObjectMapperUtils.mapAll(this.hddMetricService.getAll(), HddMetricDTO.class);
                if (hddMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(hddMetricList, HttpStatus.OK);
            case "memory":
                List<MemoryMetricDTO> memoryMetricList = ObjectMapperUtils.mapAll(this.memoryMetricService.getAll(), MemoryMetricDTO.class);
                if (memoryMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(memoryMetricList, HttpStatus.OK);
            case "ssd":
                List<SsdMetricDTO> ssdMetricList = ObjectMapperUtils.mapAll(this.ssdMetricService.getAll(), SsdMetricDTO.class);
                if (ssdMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(ssdMetricList, HttpStatus.OK);
            case "taskCount":
                List<TaskMetricDTO> taskMetricList = ObjectMapperUtils.mapAll(this.taskMetricService.getAll(), TaskMetricDTO.class);
                if (taskMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(taskMetricList, HttpStatus.OK);
            case "all":
                List<BaseMetricDTO> allMetricList = new ArrayList<>();
                List<CpuMetricDTO> cpuAllMetricList = ObjectMapperUtils.mapAll(this.cpuMetricService.getAll(), CpuMetricDTO.class);
                List<HddMetricDTO> hddAllMetricList = ObjectMapperUtils.mapAll(this.hddMetricService.getAll(), HddMetricDTO.class);
                List<MemoryMetricDTO> memoryAllMetricList = ObjectMapperUtils.mapAll(this.memoryMetricService.getAll(), MemoryMetricDTO.class);
                List<SsdMetricDTO> ssdAllMetricList = ObjectMapperUtils.mapAll(this.ssdMetricService.getAll(), SsdMetricDTO.class);
                List<TaskMetricDTO> taskAllMetricList = ObjectMapperUtils.mapAll(this.taskMetricService.getAll(), TaskMetricDTO.class);
                allMetricList.addAll(cpuAllMetricList);
                allMetricList.addAll(hddAllMetricList);
                allMetricList.addAll(memoryAllMetricList);
                allMetricList.addAll(ssdAllMetricList);
                allMetricList.addAll(taskAllMetricList);
                if (allMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(allMetricList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMetrics(@RequestBody List<BaseMetric> metrics) {
        for (BaseMetric m : metrics) {
            if (m.getName().equals("cpu")) {
                CpuMetric cpu = new CpuMetric(m);
                cpuMetricService.save(cpu);
            }
            if (m.getName().equals("hdd")) {
                HddMetric hdd = new HddMetric(m);
                hddMetricService.save(hdd);
            }
            if (m.getName().equals("memory")) {
                MemoryMetric memory = new MemoryMetric(m);
                memoryMetricService.save(memory);
            }
            if (m.getName().equals("ssd")) {
                SsdMetric ssd = new SsdMetric(m);
                ssdMetricService.save(ssd);
            }
            if (m.getName().equals("taskCount")) {
                TaskMetric task = new TaskMetric(m);
                taskMetricService.save(task);
            }
        }

    }
}







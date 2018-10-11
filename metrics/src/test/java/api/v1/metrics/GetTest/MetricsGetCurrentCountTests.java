package api.v1.metrics.GetTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Класс для тестирования запроса http://localhost:8080/api/v1/metrics/get/{name}/{count}
 * При выполнении данных тестов мы должны получить последние N (N- число указанное в параметре  {count} запроса)
 * самых свежих метрик указанного типа (тип - имя метрики указанное в параметре {name} запроса)
 * Перед выполнением тестов необходимо проверить, что
 * в базе данных количество записей для каждого типа метрик больше количества запрашиваемых
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricsGetCurrentCountTests {
    int count = 2; // число запрашиваемых метрик

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetCpuCountListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/cpu/" + count;
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int cpuCount = 0;
        for (String l : list) {
            if (l.contains("\"name\":\"cpu\"")) {
                cpuCount++;
            } else {
                break;
            }
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, cpuCount == count);
    }

    @Test
    public void testGetHddDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/hdd/" + count;
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int hddCount = 0;
        for (String l : list) {
            if (l.contains("\"name\":\"hdd\"")) {
                hddCount++;
            } else {
                break;
            }
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == hddCount);
    }

    @Test
    public void testGetMemoryDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/memory/" + count;
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int memoryCount = 0;
        for (String l : list) {
            if (l.contains("\"name\":\"memory\"")) {
                memoryCount++;
            } else {
                break;
            }
        }
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == memoryCount);
    }

    @Test
    public void testGetSsdDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/ssd/" + count;
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int ssdCount = 0;
        for (String l : list) {
            if (l.contains("\"name\":\"ssd\"")) {
                ssdCount++;
            } else {
                break;
            }
        }
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == ssdCount);
    }

    @Test
    public void testGetTaskDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/taskCount/" + count;
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int taskCount = 0;
        for (String l : list) {
            if (l.contains("\"name\":\"taskCount\"")) {
                taskCount++;
            } else {
                break;
            }
        }
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == taskCount);
    }

    @Test
    public void testGetAllDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/all/" + count;
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int cpuCount = 0;
        int hddCount = 0;
        int memoryCount = 0;
        int ssdCount = 0;
        int taskCount = 0;
        for (String l : list) {
            if (l.contains("\"name\":\"cpu\"")) {
                cpuCount++;
            } else if (l.contains("\"name\":\"hdd\"")) {
                hddCount++;
            } else if (l.contains("\"name\":\"memory\"")) {
                memoryCount++;
            } else if (l.contains("\"name\":\"ssd\"")) {
                ssdCount++;
            } else if (l.contains("\"name\":\"taskCount\"")) {
                taskCount++;
            }
            else {
                break;
            }
        }
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, cpuCount == count);
        Assert.assertEquals(true, hddCount == count);
        Assert.assertEquals(true, ssdCount == count);
        Assert.assertEquals(true, memoryCount == count);
        Assert.assertEquals(true, taskCount == count);
    }
}

package api.v1.metrics.getTest;

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
 * По умолчанию мы должны получить последние 3 самые свежие метрики указанного типа
 * Перед выполнением тестов необходимо проверить что в базе данных есть как минимум по 3 записи для каждого типа метрик
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricsGetCurrentDefaultTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetCpuCountListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/cpu";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int count = 0;
        for (String l : list) {
            if (!(l.contains("\"name\":\"cpu\""))) {
                break;
            }
            count++;
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == 3);
    }

    @Test
    public void testGetHddDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/hdd";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int count = 0;
        for (String l : list) {
            if (!(l.contains("\"name\":\"hdd\""))) {
                break;
            }
            count++;
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == 3);
    }

    @Test
    public void testGetMemoryDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/memory";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int count = 0;
        for (String l : list) {
            if (!(l.contains("\"name\":\"memory\""))) {
                break;
            }
            count++;
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == 3);
    }

    @Test
    public void testGetSsdDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/ssd";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int count = 0;
        for (String l : list) {
            if (!(l.contains("\"name\":\"ssd\""))) {
                break;
            }
            count++;
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == 3);
    }

    @Test
    public void testGetTaskDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/taskCount";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int count = 0;
        for (String l : list) {
            if (!(l.contains("\"name\":\"taskCount\""))) {
                break;
            }
            count++;
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == 3);
    }

    @Test
    public void testGetAllDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/all";
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
            }
            if (l.contains("\"name\":\"hdd\"")) {
                hddCount++;
            }
            if (l.contains("\"name\":\"memory\"")) {
                memoryCount++;
            }
            if (l.contains("\"name\":\"ssd\"")) {
                ssdCount++;
            }
            if (l.contains("\"name\":\"taskCount\"")) {
                taskCount++;
            }
        }
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, cpuCount == 3);
        Assert.assertEquals(true, hddCount == 3);
        Assert.assertEquals(true, ssdCount == 3);
        Assert.assertEquals(true, memoryCount == 3);
        Assert.assertEquals(true, taskCount == 3);
    }
}

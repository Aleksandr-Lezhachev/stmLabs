package api.v1.metrics.GetTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
/**
 * Тесты для проверки возвращаемых кодов ошибок при невалидном запросе
 *
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricsValidateGetTests {

    @Test
    public void testValidateParamOneSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get";
        URI uri = new URI(baseUrl);
        try {
            ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        }catch (HttpClientErrorException ex) {
            Assert.assertEquals(400, ex.getRawStatusCode());
        }
    }
    @Test
    public void testValidateParamTwoSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/";
        URI uri = new URI(baseUrl);
        try {
            ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        }catch (HttpClientErrorException ex) {
            Assert.assertEquals(400, ex.getRawStatusCode());
        }
    }
    @Test
    public void testValidateParamThreeSuccess() throws URISyntaxException {
        String metric_name = "foo"; // имя несуществующей метрики
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/"+metric_name;
        URI uri = new URI(baseUrl);
        try {
            ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        }catch (HttpClientErrorException ex) {
            Assert.assertEquals(400, ex.getRawStatusCode());
        }
    }
    @Test
    public void testValidateParamFourSuccess() throws URISyntaxException {
        String metric_name = "foo"; // имя несуществующей метрики
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/"+metric_name+"/";
        URI uri = new URI(baseUrl);
        try {
            ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        }catch (HttpClientErrorException ex) {
            Assert.assertEquals(400, ex.getRawStatusCode());
        }
    }
}

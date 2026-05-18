package tutoring.animal.fact;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class FactService {
    private final RestTemplate restTemplate = new RestTemplate();

    // 고양이 상식
    public Map<String, Object> getCatFact() {
        String url = "https://catfact.ninja/fact";
        return restTemplate.getForObject(url, Map.class);
    }

    public Map<String, Object> getDogFact() {
        String url = "https://dogapi.dog/api/v2/facts";
        return restTemplate.getForObject(url, Map.class);
    }
}

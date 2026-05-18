package tutoring.animal.fact;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FactController {

    private final FactService factService;

    // 강아지 상식 가져오기 (DB 저장 안 함)
    @GetMapping("/dog-fact")
    public Map<String, Object> dogFact() {
        return factService.getDogFact();
    }

    // 고양이 상식 가져오기 (DB 저장 안 함)
    @GetMapping("/cat-fact")
    public Map<String, Object> catFact() {
        return factService.getCatFact();
    }
}
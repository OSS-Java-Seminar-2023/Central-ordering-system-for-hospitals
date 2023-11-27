import model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping
    public List<Result> getAllResults() {
        return resultService.getAllResults();
    }

    @GetMapping("/{id}")
    public Result getResultById(@PathVariable String id) {
        return resultService.getResultById(id);
    }

    @PostMapping
    public Result createResult(@RequestBody Result result) {
        return resultService.saveResult(result);
    }

    @PutMapping("/{id}")
    public Result updateResult(@PathVariable String id, @RequestBody Result result) {
        return resultService.saveResult(result);
    }

    @DeleteMapping("/{id}")
    public void deleteResult(@PathVariable String id) {
        resultService.deleteResult(id);
    }
}

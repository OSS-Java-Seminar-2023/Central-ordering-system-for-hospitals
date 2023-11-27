package services;

import model.Result;
import java.util.List;

public interface ResultService {
    List<Result> getAllResults();
    Result getResultById(String id);
    Result saveResult(Result result);
    void deleteResult(String id);
}

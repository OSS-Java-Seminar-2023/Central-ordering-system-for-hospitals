package com.example.Hospital.controllers;

import com.example.Hospital.models.*;
import com.example.Hospital.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultControllor {

    @Autowired
    private ResultServices resultServices;

    @GetMapping
    public List<Result> getAllResults() {
        return resultServices.getAllResults();
    }

    @GetMapping("/{id}")
    public Result getResultById(@PathVariable String id) {
        return resultServices.getResultById(id);
    }

    @PostMapping
    public Result createResult(@RequestBody Result result) {
        return resultServices.saveResult(result);
    }



    @DeleteMapping("/{id}")
    public void deleteResult(@PathVariable String id) {
        resultServices.deleteResult(id);
    }
}

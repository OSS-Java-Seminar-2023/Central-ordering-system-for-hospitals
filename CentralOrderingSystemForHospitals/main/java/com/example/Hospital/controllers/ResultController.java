package com.example.Hospital.controllers;

import com.example.Hospital.models.Result;
import com.example.Hospital.services.ResultServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultServices resultServices;

    @GetMapping
    public String getAllResults(Model model) {
        List<Result> results = resultServices.getAllResults();
        model.addAttribute("results", results);
        return "result/list";  // Assuming you have a Thymeleaf template named "result/list.html"
    }

    @GetMapping("/{id}")
    public String getResultById(@PathVariable String id, Model model) {
        Result result = resultServices.getResultById(id);
        model.addAttribute("result", result);
        return "result/details";  // Assuming you have a Thymeleaf template named "result/details.html"
    }

    @GetMapping("/search")
    public String searchResults(@RequestParam Map<String, String> params, Model model) {
        List<Result> results = resultServices.searchResults(params);
        model.addAttribute("results", results);
        return "result/list";  // Assuming you have a Thymeleaf template named "result/list.html"
    }

    @PostMapping
    public String createResult(@ModelAttribute("result") Result result) {
        Result createdResult = resultServices.saveResult(result);
        return "redirect:/results/" + createdResult.getId();
    }

    @DeleteMapping("/{id}")
    public String deleteResult(@PathVariable String id) {
        resultServices.deleteResult(id);
        return "redirect:/results";
    }
}

package com.example.Hospital.services;

import com.example.Hospital.models.*;
import com.example.Hospital.repositories.ResultRepository;
import com.example.Hospital.services.Spec.ResultSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ResultServices {

    ResultRepository resultRepository;
    public List<Result> getAllResults(){
        return resultRepository.findAll();
    }
    public Result getResultById(String id){
        return resultRepository.getReferenceById(id);
    }
    public Result saveResult(Result result){
        return resultRepository.save(result);
    }

    public List<Result> searchResults(Map<String, String> params) {
        Specification<Result> spec = ResultSpecification.buildSpecifications(params);
        return resultRepository.findAll(spec);
    }
    public void deleteResult(String id){
        resultRepository.deleteById(id);
    }
}

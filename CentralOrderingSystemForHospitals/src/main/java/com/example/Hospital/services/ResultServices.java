package com.example.Hospital.services;

import com.example.Hospital.models.*;
import com.example.Hospital.repositories.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void deleteResult(String id){
        resultRepository.deleteById(id);
    }
}

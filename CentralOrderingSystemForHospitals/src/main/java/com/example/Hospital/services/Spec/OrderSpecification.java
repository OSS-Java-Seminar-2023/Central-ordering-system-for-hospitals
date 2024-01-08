package com.example.Hospital.services.Spec;
import com.example.Hospital.models.Order;
import org.springframework.data.jpa.domain.Specification;


public class OrderSpecification {

    public static Specification<Order> withUserId(String userId) {
        return (root, query, cb) -> cb.equal(root.get("user").get("id"), userId);
    }

    public static Specification<Order> withResultId(String resultId) {
        return (root, query, cb) -> cb.equal(root.get("result").get("id"), resultId);
    }

    // Add more methods for additional parameters



}

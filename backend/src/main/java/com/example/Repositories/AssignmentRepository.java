package com.example.Repositories;

import com.example.Models.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssignmentRepository extends MongoRepository<Assignment, Long> {
    List<Assignment> findByClassId(String classId);
}

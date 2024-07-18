package com.example.backend.Repositories;

import com.example.backend.Models.TestResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestResultRepository extends MongoRepository<TestResult, String> {
}

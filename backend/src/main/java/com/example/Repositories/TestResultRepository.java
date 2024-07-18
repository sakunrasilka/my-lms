package com.example.Repositories;

import com.example.Models.TestResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestResultRepository extends MongoRepository<TestResult, String> {
}

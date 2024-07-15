package com.example.Repositories;

import com.example.Models.AssignmentSubmission;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssignmentSubmissionRepository extends MongoRepository<AssignmentSubmission, Long> {
}

package com.example.backend.Repositories;

import com.example.backend.Models.AssignmentSubmission;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssignmentSubmissionRepository extends MongoRepository<AssignmentSubmission, Long> {
}

package com.example.backend.Service;

import com.example.backend.Models.AssignmentSubmission;
import com.example.backend.Repositories.AssignmentSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentSubmissionService {
    @Autowired
    private AssignmentSubmissionRepository assignmentSubmissionRepository;

    public AssignmentSubmission save(AssignmentSubmission submission) {
        return assignmentSubmissionRepository.save(submission);
    }
}

package com.example.Service;

import com.example.Models.AssignmentSubmission;
import com.example.Repositories.AssignmentSubmissionRepository;
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

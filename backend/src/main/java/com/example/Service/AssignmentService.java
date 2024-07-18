package com.example.Service;

import com.example.Models.Assignment;
import com.example.Repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment save(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> findByClassId(String classId) {
        return assignmentRepository.findByClassId(classId);
    }
}

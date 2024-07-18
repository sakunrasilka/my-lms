package com.example.Service;

import com.example.Models.TestResult;
import com.example.Repositories.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestResultService {

    @Autowired
    private TestResultRepository testResultRepository;

    public List<TestResult> getAllStudents() {
        return testResultRepository.findAll();
    }

    public TestResult getStudentById(String id) {
        return testResultRepository.findById(id).orElse(null);
    }

    public TestResult addStudent(TestResult student_result) {
        return testResultRepository.save(student_result);
    }

    // Add other service methods as needed
}

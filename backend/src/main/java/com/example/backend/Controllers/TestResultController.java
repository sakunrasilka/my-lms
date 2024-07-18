package com.example.backend.Controllers;

import com.example.backend.Models.TestResult;
import com.example.backend.Service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class TestResultController {

    @Autowired
    private TestResultService testResultService;

    @GetMapping
    public List<TestResult> getAllStudents() {
        return testResultService.getAllStudents();
    }

    @GetMapping("/{id}")
    public TestResult getStudentById(@PathVariable String id) {
        return testResultService.getStudentById(id);
    }

    @PostMapping
    public TestResult addStudent(@RequestBody TestResult student) {
        return testResultService.addStudent(student);
    }

    // Add other endpoints as needed
}

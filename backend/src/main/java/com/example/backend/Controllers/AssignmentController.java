package com.example.backend.Controllers;

import com.example.backend.Models.Assignment;
import com.example.backend.Service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/create")
    public Response createAssignment(@RequestBody Assignment assignment) {
        assignmentService.save(assignment);
        return new Response(true, "Assignment created successfully");
    }

    @GetMapping("/class/{classId}")
    public List<Assignment> getAssignmentsByClass(@PathVariable String classId) {
        return assignmentService.findByClassId(classId);
    }

    static class Response {
        public boolean success;
        public String message;

        public Response(boolean success, String message) {
            this.success = success;
            this.message = message;
        }
    }
}

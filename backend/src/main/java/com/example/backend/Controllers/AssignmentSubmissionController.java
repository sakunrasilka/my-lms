package com.example.backend.Controllers;

import com.example.backend.Models.AssignmentSubmission;
import com.example.backend.Service.AssignmentSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentSubmissionController {
    @Autowired
    private AssignmentSubmissionService assignmentSubmissionService;

    @PostMapping("/submit")
    public Response submitAssignment(@RequestParam("assignmentId") Long assignmentId,
                                     @RequestParam("userId") Long userId,
                                     @RequestParam("file") MultipartFile file) {
        try {
            String folder = "uploads/";
            byte[] bytes = file.getBytes();
            Path path = Paths.get(folder + file.getOriginalFilename());
            Files.write(path, bytes);

            AssignmentSubmission submission = new AssignmentSubmission();
            submission.setAssignmentId(assignmentId);
            submission.setUserId(userId);
            submission.setFilePath(path.toString());

            assignmentSubmissionService.save(submission);

            return new Response(true, "Assignment submitted successfully");
        } catch (Exception e) {
            return new Response(false, "Submission failed");
        }
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

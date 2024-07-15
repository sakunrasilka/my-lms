package com.example.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "assignment_submission")
public class AssignmentSubmission {
    @Id
    private Long id;
    private Long assignmentId;
    private Long userId;
    private String filePath;

    // Getters and setters
}

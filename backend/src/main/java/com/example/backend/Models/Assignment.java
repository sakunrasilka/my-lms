package com.example.backend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "assignment_details")
public class Assignment {
    @Id
    private Long id;
    private String title;
    private String description;
    private LocalDate deadline;
    private String classId;

    // Getters and setters
}

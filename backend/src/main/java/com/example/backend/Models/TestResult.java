package com.example.backend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "test_result")
public class TestResult {
    @Id
    private String id;
    private String name;
    private String school;
    private int[] testScores;

    // Getters and setters
}

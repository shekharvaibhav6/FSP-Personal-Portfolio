package com.example.Portfolio_backend.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin
public class ResumeController {

    @GetMapping("/download")
    @ResponseBody
    public ResponseEntity<FileSystemResource> downloadResume() {
        // The path to your resume file
        FileSystemResource file = new FileSystemResource("src/main/resources/static/VaibhavShekhar.pdf");

        if (file.exists()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=resume.pdf");
            return new ResponseEntity<>(file, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

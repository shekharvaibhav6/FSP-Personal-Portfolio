package com.example.Portfolio_backend.controller;

import com.example.Portfolio_backend.ResponseMessage;
import com.example.Portfolio_backend.entity.ContactForm;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ContactController {

    // Create a logger instance
    private static final Logger logger = LogManager.getLogger(ContactController.class);

    @PostMapping("/contact")
    public ResponseEntity<?> handleContactForm(@RequestBody ContactForm contactForm) {
        // Log the received data using Log4j
        logger.info("Received message:");
        logger.info("Name: " + contactForm.getName());
        logger.info("Email: " + contactForm.getEmail());
        logger.info("Subject: " + contactForm.getSubject());
        logger.info("Message: " + contactForm.getMessage());

        // Return success response
        return ResponseEntity.ok(new ResponseMessage("Message sent successfully!"));
    }
    @GetMapping("footer/linkedin")
    public ResponseEntity<String> getLinkedInProfile() {
        return ResponseEntity.ok("https://www.linkedin.com/in/vaibhav-shekhar-028325228");
    }

    @GetMapping("footer/github")
    public ResponseEntity<String> getGitHubProfile() {
        return ResponseEntity.ok("https://github.com/shekharvaibhav6");
    }

    @GetMapping("footer/email")
    public ResponseEntity<String> getEmail() {
        return ResponseEntity.ok("mailto:shekharvaibhav6@gmail.com");
    }

    private static final Map<String, String> projectLinks = new HashMap<>();

    static {
        // Add project names and their corresponding URLs
        projectLinks.put("project1", "https://github.com/shekharvaibhav6/Job-PortalApp");
        projectLinks.put("project2", "https://github.com/shekharvaibhav6/Quiz-App");
        projectLinks.put("project3", "https://github.com/shekharvaibhav6/GamingFriends");
        projectLinks.put("project4", "https://github.com/shekharvaibhav6/Pokedex");
        projectLinks.put("project5", "https://github.com/shekharvaibhav6/FindMyTrainProject");
        projectLinks.put("project6", "https://github.com/shekharvaibhav6/AadharPanMatcher");
        projectLinks.put("project7", "https://github.com/shekharvaibhav6/Truck-Management-System");
        projectLinks.put("project8", "https://github.com/shekharvaibhav6/Book-My-Show");
        projectLinks.put("project9", "https://github.com/shekharvaibhav6/Movie-App");
        projectLinks.put("project10", "https://github.com/shekharvaibhav6/FSP-Student-Database-Management");
        projectLinks.put("project11", "https://github.com/shekharvaibhav6/Traffic-Management-App");
        projectLinks.put("project12", "https://github.com/shekharvaibhav6/FSP-Job-Application-Tracker");
        // Add more projects as needed
    }

    @GetMapping("/view-project")
    public void redirectToProject(@RequestParam("name") String projectName, HttpServletResponse response) throws IOException {
        String projectUrl = projectLinks.get(projectName);

        if (projectUrl != null) {
            try {
                response.sendRedirect(projectUrl);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            response.sendRedirect("https://github.com/shekharvaibhav6"); // Default URL if project not found
        }
    }
}

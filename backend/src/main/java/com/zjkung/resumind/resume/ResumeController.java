package com.zjkung.resumind.resume;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/resume")
@RequiredArgsConstructor
public class ResumeController {
  private final ResumeService resumeService;

  @GetMapping
  public List<Resume> getAllResumes() {
    return resumeService.getAllResumes();
  }

  @PostMapping("/upload")
  public ResponseEntity<String> uploadResume(@RequestParam("file") MultipartFile file) {
    try {
      resumeService.saveResume(file);
      return ResponseEntity.ok("Resume uploaded successfully");
    } catch (IOException e) {
      return ResponseEntity.status(500).body("Failed to upload resume: " + e.getMessage());
    }
  }

  @PostMapping("/analyze")
  public ResponseEntity<String> analyzeResume(@RequestParam("resumeId") Long resumeId,
      @RequestParam("jobDescriptionId") Long jobDescriptionId) {
    try {
      resumeService.analyzeResume(resumeId, jobDescriptionId);
      return ResponseEntity.ok("Resume analysis completed successfully");
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Failed to analyze resume: " + e.getMessage());
    }
  }

  @GetMapping("/analysis-results")
  public ResponseEntity<List<ResumeAnalysisResult>> getAnalysisResults() {
    return ResponseEntity.ok(resumeService.getAnalysisResults());
  }
}

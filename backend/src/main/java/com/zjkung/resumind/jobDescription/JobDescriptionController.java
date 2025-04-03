package com.zjkung.resumind.jobDescription;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/job-description")
@RequiredArgsConstructor
public class JobDescriptionController {
  private final JobDescriptionService jobDescriptionService;

  public ResponseEntity<Long> createJobDescription(JobDescription jobDescription) {
    return ResponseEntity.ok(jobDescriptionService.createJobDescription(jobDescription));
  }
}

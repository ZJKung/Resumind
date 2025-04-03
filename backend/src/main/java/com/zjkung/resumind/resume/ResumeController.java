package com.zjkung.resumind.resume;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/resume")
@RequiredArgsConstructor
public class ResumeController {
  private final ResumeService resumeService;

  public List<Resume> getAllResumes() {
    return resumeService.getAllResumes();
  }
}

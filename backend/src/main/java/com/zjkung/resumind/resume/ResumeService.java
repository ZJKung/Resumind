package com.zjkung.resumind.resume;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResumeService {
  private final ResumeRepository resumeRepository;

  public List<Resume> getAllResumes() {
    return resumeRepository.findAll();
  }
}

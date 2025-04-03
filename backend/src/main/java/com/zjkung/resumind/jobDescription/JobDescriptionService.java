package com.zjkung.resumind.jobDescription;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobDescriptionService {
  private final JobDescriptionRepository jobDescriptionRepository;
  private final JobDescriptionMapper jobDescriptionMapper;

  public Long createJobDescription(JobDescription jobDescription) {
    JobDescription savedJobDescription = jobDescriptionRepository.save(jobDescription);
    return savedJobDescription.getId();
  }
}

package com.zjkung.resumind.resume;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResumeService {
  private final ResumeRepository resumeRepository;
  private final RestTemplate restTemplate = new RestTemplate();

  @Value("${spring.ai.openai.base-url}")
  private String aiBaseUrl;

  @Value("${spring.ai.openai.api-key}")
  private String apiKey;

  public List<Resume> getAllResumes() {
    return resumeRepository.findAll();
  }

  public void saveResume(MultipartFile file) throws IOException {
    Resume resume = new Resume();
    resume.setResumeName(file.getOriginalFilename());
    resume.setResumeContent(new String(file.getBytes()));
    resumeRepository.save(resume);
  }

  public void analyzeResume(Long resumeId, Long jobDescriptionId) {
    Resume resume = resumeRepository.findById(resumeId).orElseThrow(() -> new RuntimeException("Resume not found"));

    // Prepare AI request payload
    JsonNode requestPayload = prepareAiRequestPayload(resume);

    // Send request to AI service
    JsonNode response = restTemplate.postForObject(
        aiBaseUrl + "/analyze",
        requestPayload,
        JsonNode.class);

    // Process AI response
    processAiResponse(response);
  }

  private JsonNode prepareAiRequestPayload(Resume resume) {
    // Create JSON payload for AI service
    // Example: { "resumeContent": "..." }
    return JsonNodeFactory.instance.objectNode()
        .put("resumeContent", resume.getResumeContent());
  }

  private void processAiResponse(JsonNode response) {
    // Extract and save AI analysis results
    // Example: Save match score, strengths, weaknesses, etc.
    if (response != null) {
      // Process response fields as needed
    }
  }

  public List<ResumeAnalysisResult> getAnalysisResults() {
    // Placeholder logic to fetch analysis results
    // Replace with actual database queries or logic to retrieve results
    return new ArrayList<>();
  }
}

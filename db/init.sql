-- users: HR personnel login info
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  email VARCHAR(255) UNIQUE NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  full_name VARCHAR(255),
  created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);
-- job_descriptions: Job posts for matching
CREATE TABLE job_descriptions (
  id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES users(id) ON DELETE CASCADE,
  title VARCHAR(255),
  description TEXT NOT NULL,
  created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);
-- resumes: Uploaded resumes
CREATE TABLE resumes (
  id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES users(id) ON DELETE CASCADE,
  file_name VARCHAR(255),
  file_path TEXT,
  uploaded_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
  text_content TEXT
);
-- resume_matches: AI analysis results between a resume and job
CREATE TABLE resume_matches (
  id SERIAL PRIMARY KEY,
  resume_id INTEGER REFERENCES resumes(id) ON DELETE CASCADE,
  job_description_id INTEGER REFERENCES job_descriptions(id) ON DELETE CASCADE,
  match_score NUMERIC(5, 2),
  -- e.g., 87.50
  fit_summary TEXT,
  strengths TEXT,
  weaknesses TEXT,
  extracted_skills TEXT[],
  keywords_matched TEXT[],
  created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);
-- Optional: logs for admin panel (advanced)
CREATE TABLE admin_logs (
  id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES users(id),
  action TEXT,
  details TEXT,
  created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

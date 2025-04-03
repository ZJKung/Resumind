package com.zjkung.resumind.user;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "\"user\"")
public class User {
  @Getter
  @Setter
  @Id
  @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
  private Long id;
  @Getter
  @Setter
  private String email;
  @Getter
  @Setter
  @Column(name = "password_hash")
  private String passwordHash;
  @Getter
  @Setter
  @Column(name = "full_name")
  private String fullName;
  @CreatedDate
  @Column(updatable = false)
  private LocalDateTime createdDate;
}

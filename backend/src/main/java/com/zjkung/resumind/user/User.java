package com.zjkung.resumind.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
}

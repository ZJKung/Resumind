package com.zjkung.resumind.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"user\"")
public class User {
  @Id
  @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
  private Long id;
  private String email;
  @Column(name = "password_hash")
  private String passwordhash;
  @Column(name = "full_name")
  private String fullname;
}

package com.dio.bankchallenge.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

@Data
public class Client {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", columnDefinition = "VARCHAR(255)")
  private UUID id;

  @Column(nullable = false, length = 13, unique = true, updatable = false)
  private String document;

  @Column(nullable = false, length = 25, unique = true, updatable = true)
  private String name;

  @Column(nullable = false, length = 86, unique = true, updatable = true)
  private String email;

  @Column(nullable = false, length = 25, unique = true, updatable = true)
  private String login;

  @Column(nullable = false, unique = false, updatable = true)
  private String password;
}

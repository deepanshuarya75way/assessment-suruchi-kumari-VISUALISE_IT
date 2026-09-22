package com.example.educate_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = 'refresh_tokens')
@Data
@NoArgsConstructor
@AllArgsConstructor

public classs Refreshtoken{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(nullable = false, unique = true)
  private String token;
  @OnetoOne
  @JoinColumn(name = "user_id",referencedColumnName="id")
  private User user;
  private Instant expiryDate;
}
package com.example.educate_backend.Repository;

import com.example.educate_backend.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;
 public interface RefreshTokenRepository extends JpaRepository<Refreshtoken,long>{
      Optional<Refreshtoken> findByToken(string token);
      @Modifying
      @Query("Delete from RefreshToken r where r.user =?")
      void deleteByUser(User user);
 }
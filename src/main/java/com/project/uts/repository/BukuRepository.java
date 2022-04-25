package com.project.uts.repository;

import com.project.uts.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BukuRepository extends JpaRepository<Buku, Long> {

    // Query method
    Optional<Buku> findByJudul(String judul);
}
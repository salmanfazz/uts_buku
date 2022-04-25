package com.project.uts.service.framework;

import com.project.uts.entity.Buku;

import java.util.List;
import java.util.Optional;

public interface BukuService {
    List<Buku> getBukus();

    Optional<Buku> findById(Long id);

    Optional<Buku> findByJudul(String judul);

    Buku save(Buku std);

    void deleteById(Long id);
}

package com.project.uts.service.implementation;

import com.project.uts.entity.Buku;
import com.project.uts.repository.BukuRepository;
import com.project.uts.service.framework.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BukuServiceImpl implements BukuService {
    private final BukuRepository bukuRepository;

    @Autowired
    public BukuServiceImpl(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    @Override
    public List<Buku> getBukus() {
        return bukuRepository.findAll();
    }

    @Override
    public Optional<Buku> findById(Long id) {
        return bukuRepository.findById(id);
    }

    @Override
    public Optional<Buku> findByJudul(String judul) {
        return bukuRepository.findByJudul(judul);
    }

    @Override
    public Buku save(Buku std) {
        return bukuRepository.save(std);
    }

    @Override
    public void deleteById(Long id) {
        bukuRepository.deleteById(id);
    }
}


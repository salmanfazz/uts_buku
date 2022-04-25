package com.project.uts.controller;

import com.project.uts.entity.Buku;
import com.project.uts.exception.BukuNotFoundException;
import com.project.uts.service.framework.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/bukus")
public class BukuController {
    private final BukuService bukuService;

    @Autowired
    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @GetMapping
    public List<Buku> getBukus() {
        return bukuService.getBukus();
    }

    @GetMapping(value = "/{id}")
    public Buku getBukuById(@PathVariable("id") @Min(1) Long id) {
            Buku std = bukuService.findById(id)
                .orElseThrow(() -> new BukuNotFoundException("Buku with " + id + " is Not Found!"));
        return std;
    }

    @PostMapping
    public Buku addBuku(@Valid @RequestBody Buku std) {
        return bukuService.save(std);
    }

    @PutMapping(value = "/{id}")
    public Buku updateBuku(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Buku newStd) {
        Buku buku = bukuService.findById(id)
                .orElseThrow(() -> new BukuNotFoundException("Buku with " + id + " is Not Found!"));
        buku.setKode_buku(newStd.getKode_buku());
        buku.setJudul(newStd.getJudul());
        buku.setNama_penerbit(newStd.getNama_penerbit());
        buku.setTahun_penerbit(newStd.getTahun_penerbit());
        return bukuService.save(buku);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteBuku(@PathVariable("id") @Min(1) Long id) {
        Buku std = bukuService.findById(id)
                .orElseThrow(() -> new BukuNotFoundException("Buku with " + id + " is Not Found!"));
        bukuService.deleteById(std.getId());
        return "Buku with ID :" + id + " is deleted";
    }
}

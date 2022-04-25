package com.project.uts.controller;

import com.project.uts.entity.Buku;
import com.project.uts.service.framework.BukuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BukuWebController {
    private BukuService bukuService;

    @GetMapping("/buku")
    public String index(Model model) {

        model.addAttribute("buku", bukuService.getBukus());
        return "buku";
    }

    @GetMapping(value = "/create")
    public String create1(Model model) {
        model.addAttribute("buku", new Buku());
        return "formBuku";
    }

    @PostMapping(value = "/create")
    public String tambahBuku(Model model, Buku buku) {
        model.addAttribute("buku", bukuService.save(buku));
        return "redirect:buku";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("buku", bukuService.findById(id));
        return "formBuku";
    }

    @GetMapping(value = "/hapus/{id}")
    public String hapusBuku(@PathVariable Long id) {
        bukuService.deleteById(id);
        return "buku";
    }
}

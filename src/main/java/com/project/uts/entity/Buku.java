package com.project.uts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "buku")
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Kode Buku is required")
    @NotNull(message = "kode_buku can not be null!!")
    @Column(nullable = false, name = "kode_buku")
    private String kode_buku;

    @NotEmpty(message = "Judul Buku is required")
    @NotNull(message = "judul can not be null!!")
    @Column(nullable = false, name = "judul")
    private String judul;

    @NotEmpty(message = "Nama Penerbit is required")
    @NotNull(message = "nama_penerbit can not be null!!")
    @Column(nullable = false, name = "nama_penerbit")
    private String nama_penerbit;

    @NotEmpty(message = "Tahun Terbit is required")
    @NotNull(message = "tahun_penerbit can not be null!!")
    @Column(nullable = false, name = "tahun_penerbit")
    private String tahun_penerbit;
}

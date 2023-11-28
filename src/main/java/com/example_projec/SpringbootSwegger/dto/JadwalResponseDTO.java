package com.example_projec.SpringbootSwegger.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;

@Getter
@Setter
@ToString
public class JadwalResponseDTO {
    private Long id;
    private String namaDosen;
    private String email;
    private String kode;
    private String namaMatakuliah;
    private Integer sks;
    private String hari;
    private Time mulaiPelajaran;
    private Time akhirPelajaran;
    private String kelas;

}

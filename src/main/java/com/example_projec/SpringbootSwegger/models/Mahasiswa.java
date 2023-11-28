package com.example_projec.SpringbootSwegger.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Transactional
@Schema(description = "Mahasiswa entity")
@Table(name= "mahasiswa")
public class Mahasiswa {

    @Id
    private Long nim;
    private String nama;
    private String tgl_lahir;
    private String alamat_mhs;
    private String email;
    private Long telpon;
    private Integer deleted_flag;

    public Mahasiswa(Long nim, String nama, String tgl_lahir, String alamat_mhs, String email, Long telpon, Integer deleted_flag ) {
        this.nim = nim;
        this.nama = nama;
        this.tgl_lahir = tgl_lahir;
        this.alamat_mhs = alamat_mhs;
        this.email = email;
        this.telpon = telpon;
        this.deleted_flag = deleted_flag;
    }
}
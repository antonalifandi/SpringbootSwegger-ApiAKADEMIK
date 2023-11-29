package com.example_projec.SpringbootSwegger.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Dosen entity")
@Table(name = "dosen")
public class Dosen {

    @Id
    @JsonIgnore
    private Long nip;
    private String nama;
    private String tgl_lahir;
    private String alamat;
    private String email;
    private Long telpon;
    @JsonIgnore
    private Integer deleted_flag;

    public Dosen(Long nip, String nama, String tgl_lahir, String alamat, String email, Long telpon, Integer deleted_flag) {
        this.nip = nip;
        this.nama = nama;
        this.tgl_lahir = tgl_lahir;
        this.alamat = alamat;
        this.email = email;
        this.telpon = telpon;
        this.deleted_flag = deleted_flag;
    }
}

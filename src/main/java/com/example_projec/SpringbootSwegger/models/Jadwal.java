package com.example_projec.SpringbootSwegger.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Transactional
@Schema(description = "Jadwal entity")
@Table(name = "jadwal")
public class Jadwal {

    @Id
    @JsonIgnore
    private Long id;
    private String hari;
    private Time mulai_pelajaran;
    private Time akhir_pelajaran;
    private String kelas;
    @JsonIgnore
    private Integer deleted_flag;

    public Jadwal(Long id, String hari, Time mulai_pelajaran, Time akhir_pelajaran, String kelas, Integer deleted_flag) {
        this.id = id;
        this.hari = hari;
        this.mulai_pelajaran = mulai_pelajaran;
        this.akhir_pelajaran = akhir_pelajaran;
        this.kelas = kelas;
        this.deleted_flag = deleted_flag;
    }
}

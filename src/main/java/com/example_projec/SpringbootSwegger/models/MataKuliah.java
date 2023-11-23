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
@Transactional
@Entity
@Schema(description = "MataKuliah entity")
@Table(name= "mata_kuliah")
public class MataKuliah {

    @Id
    private Long id;
    private String nama_matkul;
    private Integer sks;
    private Integer kode;
    @Schema(hidden = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "deleted_flag")
    private Integer deleted_flag;

    public MataKuliah(Long id, String nama_matkul, Integer sks, Integer kode) {
        this.id = id;
        this.nama_matkul = nama_matkul;
        this.sks = sks;
        this.kode = kode;
    }
}

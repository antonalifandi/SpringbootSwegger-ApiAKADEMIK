package com.example_projec.SpringbootSwegger.services;

import com.example_projec.SpringbootSwegger.models.Mahasiswa;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public interface MahasiswaService {
    public List<Mahasiswa> getAll();
    Mahasiswa getByNim(Long nim);
    Mahasiswa addMahasiswa(Mahasiswa mahasiswa);
    void updateMahasiswa(Long nim, Mahasiswa mahasiswa);
    String deleteMahasiswa(Long nim);

}

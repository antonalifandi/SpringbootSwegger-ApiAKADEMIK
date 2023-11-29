package com.example_projec.SpringbootSwegger.services;

import com.example_projec.SpringbootSwegger.models.Jadwal;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public interface JadwalService {
    List<Jadwal> getAllJadwals();
    Jadwal getById(Long id);
    Jadwal addJadwal(Jadwal jadwal);
    void updateJadwal(Jadwal jadwal);
    String deleteJadwal(Long id);

}


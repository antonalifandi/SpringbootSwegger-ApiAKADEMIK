package com.example_projec.SpringbootSwegger.services;

import com.example_projec.SpringbootSwegger.models.Jadwal;
import com.example_projec.SpringbootSwegger.repositories.JadwalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JadwalServiceImpl implements JadwalService{

    @Autowired
    private JadwalRepository jadwalRepository;

    @Override
    public List<Jadwal> getAllJadwals() {
        return jadwalRepository.getAll();
    }

    public Jadwal getById(Long id) {
        return jadwalRepository.getById(id);
    }
    public Jadwal addJadwal(Jadwal jadwal) {
        Jadwal jdl = new Jadwal();
        jdl = jadwal;
        jadwalRepository.save(jdl);
        return jadwal;
    }
    public void updateJadwal(Long id, Jadwal updatedJadwal) {
        Optional<Jadwal> optionalJadwal = jadwalRepository.findById(id);
        if (optionalJadwal.isPresent()) {
            Jadwal existingJadwal = optionalJadwal.get();
            existingJadwal.setHari(updatedJadwal.getHari());
            existingJadwal.setMulai_pelajaran(updatedJadwal.getMulai_pelajaran());
            existingJadwal.setAkhir_pelajaran(updatedJadwal.getAkhir_pelajaran());
            existingJadwal.setKelas(updatedJadwal.getKelas());
            existingJadwal.setDeleted_flag(updatedJadwal.getDeleted_flag());
            jadwalRepository.save(existingJadwal);
        }
    }
    public String deleteJadwal(Long id) {
        jadwalRepository.deleteById(id);
        return "Jadwal removed !!!";
    }


}

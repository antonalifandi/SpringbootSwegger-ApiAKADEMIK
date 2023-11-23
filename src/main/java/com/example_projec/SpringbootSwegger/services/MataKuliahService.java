package com.example_projec.SpringbootSwegger.services;

import com.example_projec.SpringbootSwegger.models.MataKuliah;
import com.example_projec.SpringbootSwegger.repositories.MataKuliahRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MataKuliahService {

    @Autowired
    private MataKuliahRepository matakuliahRepository;
    public List<MataKuliah> getAllMataKuliah() {
        return matakuliahRepository.findByDeletedFlagNot(1);
    }
    public MataKuliah getMataKuliahById(Long id) {
        Optional<MataKuliah> optionalMataKuliah = matakuliahRepository.findById(id);
        return optionalMataKuliah.orElse(null);
    }
    public void addMataKuliah(MataKuliah matakuliah) {
        matakuliahRepository.save(matakuliah);
    }
    public void updateMataKuliah(Long id, MataKuliah updatedMataKuliah) {
        Optional<MataKuliah> optionalMataKuliah = matakuliahRepository.findById(id);
        if (optionalMataKuliah.isPresent()) {
            MataKuliah existingMataKuliah = optionalMataKuliah.get();
            existingMataKuliah.setNama_matkul(updatedMataKuliah.getNama_matkul());
            existingMataKuliah.setSks(updatedMataKuliah.getSks());
            existingMataKuliah.setKode(updatedMataKuliah.getKode());
            matakuliahRepository.save(existingMataKuliah);
        }
    }
    public String deleteMataKuliah(Long id) {
        matakuliahRepository.deleteMataKuliah(id);
        return "Dosen removed !!!";
    }
}

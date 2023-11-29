package com.example_projec.SpringbootSwegger.services;

import com.example_projec.SpringbootSwegger.models.MataKuliah;
import com.example_projec.SpringbootSwegger.repositories.MataKuliahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MataKuliahServiceImpl implements MataKuliahService  {

    @Autowired
    private MataKuliahRepository matakuliahRepository;

    public List<MataKuliah> getAll() {
        return matakuliahRepository.getAllData();
    }

    public MataKuliah getById(Long id) {
        return matakuliahRepository.getById(id);
    }

    public MataKuliah addMataKuliah(MataKuliah matakuliah) {
        MataKuliah mk = new MataKuliah();
        mk = matakuliah;
        matakuliahRepository.save(mk);
        return matakuliah;
    }

    public void updateMataKuliah(MataKuliah updatedMataKuliah) {
        Optional<MataKuliah> optionalMataKuliah = matakuliahRepository.findById(updatedMataKuliah.getId());
        if (optionalMataKuliah.isPresent()) {
            MataKuliah existingMataKuliah = optionalMataKuliah.get();
            existingMataKuliah.setNama_matkul(updatedMataKuliah.getNama_matkul());
            existingMataKuliah.setSks(updatedMataKuliah.getSks());
            existingMataKuliah.setKode(updatedMataKuliah.getKode());
            existingMataKuliah.setDeleted_flag(updatedMataKuliah.getDeleted_flag());
            matakuliahRepository.save(existingMataKuliah);
        }
    }
    public String deleteMataKuliah(Long id) {
        matakuliahRepository.deleteById(id);
        return "Mahasiswa removed !!!";
    }
}

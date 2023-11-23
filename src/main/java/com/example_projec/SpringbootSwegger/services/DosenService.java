package com.example_projec.SpringbootSwegger.services;

import com.example_projec.SpringbootSwegger.models.Dosen;
import com.example_projec.SpringbootSwegger.repositories.DosenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DosenService {

    @Autowired
    private DosenRepository dosenRepository;
    public List<Dosen> getAllDosen() {
        return dosenRepository.findByDeletedFlagNot(1);
    }
    public Dosen getDosenByNip(Long nip) {
        Optional<Dosen> optionalDosen = dosenRepository.findById(nip);
        return optionalDosen.orElse(null);
    }
    public void addDosen(Dosen dosen) {
        dosenRepository.save(dosen);
    }
    public void updateDosen(Long nip, Dosen updatedDosen) {
        Optional<Dosen> optionalDosen = dosenRepository.findById(nip);
        if (optionalDosen.isPresent()) {
            Dosen existingDosen = optionalDosen.get();
            existingDosen.setNama(updatedDosen.getNama());
            existingDosen.setTgl_lahir(updatedDosen.getTgl_lahir());
            existingDosen.setAlamat(updatedDosen.getAlamat());
            existingDosen.setEmail(updatedDosen.getEmail());
            existingDosen.setTelpon(updatedDosen.getTelpon());
            dosenRepository.save(existingDosen);
        }
    }
    public String deleteDosen(Long nip) {
        dosenRepository.deleteDosen(nip);
    return "Dosen removed !!!";
    }
}

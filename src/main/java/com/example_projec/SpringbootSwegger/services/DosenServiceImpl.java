package com.example_projec.SpringbootSwegger.services;

import com.example_projec.SpringbootSwegger.models.Dosen;
import com.example_projec.SpringbootSwegger.repositories.DosenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DosenServiceImpl implements DosenService{

    @Autowired
    private DosenRepository dosenRepository;

    public List<Dosen> getAll() {
        return dosenRepository.getAllData();
    }

    public Dosen getByNip(Long nip) {
        return dosenRepository.getByNip(nip);
    }

    public Dosen addDosen(Dosen dosen) {
        Dosen dsn = new Dosen();
        dsn = dosen;
        dosenRepository.save(dsn);
        return dosen;
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
            existingDosen.setDeleted_flag(updatedDosen.getDeleted_flag());
            dosenRepository.save(existingDosen);
        }
    }
    public String deleteDosen(Long nip) {
        dosenRepository.deleteByNip(nip);
        return "Dosen removed !!!";
    }
}

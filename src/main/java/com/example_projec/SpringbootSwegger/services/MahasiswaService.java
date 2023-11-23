package com.example_projec.SpringbootSwegger.services;

import com.example_projec.SpringbootSwegger.models.Mahasiswa;
import com.example_projec.SpringbootSwegger.repositories.MahasiswaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MahasiswaService {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;
    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaRepository.findByDeletedFlagNot(1);
    }
    public Mahasiswa getMahasiswaByNim(Long nim) {
        Optional<Mahasiswa> optionalMahasiswa = mahasiswaRepository.findById(nim);
        return optionalMahasiswa.orElse(null);
    }
    public void addMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaRepository.save(mahasiswa);
    }
    public void updateMahasiswa(Long nim, Mahasiswa updatedMahasiswa) {
        Optional<Mahasiswa> optionalMahasiswa = mahasiswaRepository.findById(nim);
        if (optionalMahasiswa.isPresent()) {
            Mahasiswa existingMahasiswa = optionalMahasiswa.get();
            existingMahasiswa.setNama(updatedMahasiswa.getNama());
            existingMahasiswa.setTgl_lahir(updatedMahasiswa.getTgl_lahir());
            existingMahasiswa.setAlamat_mhs(updatedMahasiswa.getAlamat_mhs());
            existingMahasiswa.setEmail(updatedMahasiswa.getEmail());
            existingMahasiswa.setTelpon(updatedMahasiswa.getTelpon());
            mahasiswaRepository.save(existingMahasiswa);
        }
    }
    public String deleteMahasiswa(Long nim) {
        mahasiswaRepository.deleteMahasiswa(nim);
        return "Dosen removed !!!";
    }
}

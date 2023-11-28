package com.example_projec.SpringbootSwegger.services;

import com.example_projec.SpringbootSwegger.models.Mahasiswa;
import com.example_projec.SpringbootSwegger.repositories.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MahasiswaServiceImpl implements MahasiswaService {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    public List<Mahasiswa> getAll() {
        return mahasiswaRepository.getAllData();
    }

    public Mahasiswa getByNim(Long nim) {
        return mahasiswaRepository.getByNim(nim);
    }

    public Mahasiswa addMahasiswa(Mahasiswa mahasiswa) {
        Mahasiswa mhs = new Mahasiswa();
        mhs = mahasiswa;
        mahasiswaRepository.save(mhs);
        return mahasiswa;
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
            existingMahasiswa.setDeleted_flag(updatedMahasiswa.getDeleted_flag());
            mahasiswaRepository.save(existingMahasiswa);
        }
    }
    public String deleteMahasiswa(Long nim) {
        mahasiswaRepository.deleteByNim(nim);
        return "Mahasiswa removed !!!";
    }
}




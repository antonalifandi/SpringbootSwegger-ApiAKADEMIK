package com.example_projec.SpringbootSwegger.controllers;

import com.example_projec.SpringbootSwegger.models.Mahasiswa;
import com.example_projec.SpringbootSwegger.services.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mahasiswa")
public class ControllerMahasiswa {

    @Autowired
    private MahasiswaService mahasiswaService;

    @GetMapping
    public List<Mahasiswa> getAllMahasiswa() {return mahasiswaService.getAllMahasiswa();
    }

    @GetMapping("/{nim}")
    public Mahasiswa getMahasiswaByNim(@PathVariable Long nim) {
        return mahasiswaService.getMahasiswaByNim(nim);
    }

    @PostMapping
    public void addMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        mahasiswaService.addMahasiswa(mahasiswa);
    }

    @PutMapping("/{nim}")
    public void updateMahasiswa(@PathVariable Long nim, @RequestBody Mahasiswa mahasiswa) {
        mahasiswaService.updateMahasiswa(nim, mahasiswa);
    }

    @DeleteMapping("/{nim}")
    public void deleteMahasiswa(@PathVariable Long nim) {
        mahasiswaService.deleteMahasiswa(nim);
    }
}


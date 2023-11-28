package com.example_projec.SpringbootSwegger.controllers;

import com.example_projec.SpringbootSwegger.models.Dosen;
import com.example_projec.SpringbootSwegger.models.Jadwal;
import com.example_projec.SpringbootSwegger.services.JadwalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/jadwal")
public class ControllerJadwal {
    @Autowired
    private JadwalService jadwalService;

    @GetMapping
    public List<Jadwal> getAll() {return jadwalService.getAllJadwals();
    }

    @GetMapping("/{id}")
    public Jadwal getById(@PathVariable Long id) {
        return jadwalService.getById(id);
    }
    @PostMapping
    public void addJadwal(@RequestBody Jadwal jadwal) {
        jadwalService.addJadwal(jadwal);
    }

    @PutMapping("/{id}")
    public void updateJadwal(@PathVariable Long id, @RequestBody Jadwal jadwal) {jadwalService.updateJadwal(id, jadwal);
    }

    @DeleteMapping("/{id}")
    public void deleteJadwal(@PathVariable Long id) {jadwalService.deleteJadwal(id);
    }
}

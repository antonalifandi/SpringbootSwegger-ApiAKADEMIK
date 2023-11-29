package com.example_projec.SpringbootSwegger.controllers;

import com.example_projec.SpringbootSwegger.models.Jadwal;
import com.example_projec.SpringbootSwegger.services.JadwalService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Jadwal addJadwal(@RequestBody Jadwal jadwal) {
        jadwalService.addJadwal(jadwal);
        return jadwal;
    }

    @PutMapping("")
    public Jadwal updateJadwal(@RequestBody Jadwal jadwal) {
        jadwalService.updateJadwal(jadwal);
        return jadwal;
    }

    @DeleteMapping("/{id}")
    public Jadwal deleteJadwal(@PathVariable Long id) {
        Jadwal jdl = jadwalService.getById(id);
        if(jdl != null){
            jadwalService.deleteJadwal(id);
        }
        return jdl;
    }
}

package com.example_projec.SpringbootSwegger.controllers;

import com.example_projec.SpringbootSwegger.models.Dosen;
import com.example_projec.SpringbootSwegger.services.DosenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dosen")
public class ControllerDosen {

    @Autowired
    private DosenService dosenService;

    @GetMapping
    public List<Dosen> getAllDosen() {
        return dosenService.getAllDosen();
    }

    @GetMapping("/{nip}")
    public Dosen getDosenByNip(@PathVariable Long nip) {
        return dosenService.getDosenByNip(nip);
    }

    @PostMapping
    public void addDosen(@RequestBody Dosen dosen) {
        dosenService.addDosen(dosen);
    }

    @PutMapping("/{nip}")
    public void updateDosen(@PathVariable Long nip, @RequestBody Dosen dosen) {
        dosenService.updateDosen(nip, dosen);
    }

    @DeleteMapping("/{nip}")
    public void deleteDosen(@PathVariable Long nip) {
        dosenService.deleteDosen(nip);
    }
}
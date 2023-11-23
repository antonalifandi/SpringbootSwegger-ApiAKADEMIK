package com.example_projec.SpringbootSwegger.controllers;

import com.example_projec.SpringbootSwegger.models.MataKuliah;
import com.example_projec.SpringbootSwegger.services.MataKuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matakuliah")
public class ControllerMataKuliah {
    @Autowired
    private MataKuliahService matakuliahService;

    @GetMapping
    public List<MataKuliah> getAllMataKuliah() {return matakuliahService.getAllMataKuliah();
    }

    @GetMapping("/{id}")
    public MataKuliah getMataKuliahByNim(@PathVariable Long id) {
        return matakuliahService.getMataKuliahById(id);
    }

    @PostMapping
    public void addMataKuliah(@RequestBody MataKuliah matakuliah) {
        matakuliahService.addMataKuliah(matakuliah);
    }

    @PutMapping("/{id}")
    public void updateMataKuliah(@PathVariable Long id, @RequestBody MataKuliah matakuliah) {
        matakuliahService.updateMataKuliah(id, matakuliah);
    }

    @DeleteMapping("/{id}")
    public void deleteMataKuliah(@PathVariable Long id) {
        matakuliahService.deleteMataKuliah(id);
    }
}

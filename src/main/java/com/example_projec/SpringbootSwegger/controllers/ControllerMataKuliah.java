package com.example_projec.SpringbootSwegger.controllers;

import com.example_projec.SpringbootSwegger.models.MataKuliah;
import com.example_projec.SpringbootSwegger.services.MataKuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matakuliah")
public class ControllerMataKuliah {

    @Autowired
    private MataKuliahService mataKuliahService;

    @GetMapping
    public List<MataKuliah> getAll() {return mataKuliahService.getAll();
    }

    @GetMapping("/{id}")
    public MataKuliah getById(@PathVariable Long id) {
        return mataKuliahService.getById(id);
    }

    @PostMapping
    public void addMataKuliah(@RequestBody MataKuliah matakuliah) {
        mataKuliahService.addMataKuliah(matakuliah);
    }

    @PutMapping("/{id}")
    public void updateMataKuliah(@PathVariable Long id, @RequestBody MataKuliah matakuliah) {
        mataKuliahService.updateMataKuliah(id, matakuliah);
    }

    @DeleteMapping("/{id}")
    public void deleteMataKuliah(@PathVariable Long id) {
        mataKuliahService.deleteMataKuliah(id);
    }
}

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
    private MataKuliahService mataKuliahService;

    @GetMapping
    public List<MataKuliah> getAll() {return mataKuliahService.getAll();
    }

    @GetMapping("/{id}")
    public MataKuliah getById(@PathVariable Long id) {
        return mataKuliahService.getById(id);
    }

    @PostMapping
    public MataKuliah addMataKuliah(@RequestBody MataKuliah matakuliah) {
        mataKuliahService.addMataKuliah(matakuliah);
        return matakuliah;
    }

    @PutMapping("")
    public MataKuliah updateMataKuliah(@RequestBody MataKuliah matakuliah) {
        mataKuliahService.updateMataKuliah(matakuliah);
        return matakuliah;
    }

    @DeleteMapping("/{id}")
    public MataKuliah deleteMataKuliah(@PathVariable Long id) {
        MataKuliah mk = mataKuliahService.getById(id);
        if(mk != null){
            mataKuliahService.deleteMataKuliah(id);
        }
        return mk;
        }
}

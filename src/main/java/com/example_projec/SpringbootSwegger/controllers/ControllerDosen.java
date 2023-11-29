package com.example_projec.SpringbootSwegger.controllers;

import com.example_projec.SpringbootSwegger.models.Dosen;
import com.example_projec.SpringbootSwegger.models.Mahasiswa;
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
    public List<Dosen> getAll() {return dosenService.getAll();
    }

    @GetMapping("/{nip}")
    public Dosen getByNip(@PathVariable Long nip) {
        return dosenService.getByNip(nip);
    }


    @PostMapping
    public Dosen addDosen(@RequestBody Dosen dosen) {
        dosenService.addDosen(dosen);
        return dosen;
    }

    @PutMapping("")
    public Dosen updateDosen(@RequestBody Dosen dosen) {
        dosenService.updateDosen(dosen);
        return dosen;
    }

    @DeleteMapping("/{nip}")
    public Dosen deleteDosen(@PathVariable Long nip) {
        Dosen dsn = dosenService.getByNip(nip);
        if (dsn != null) {
            dosenService.deleteDosen(nip);
        }
        return dsn;
    }
}

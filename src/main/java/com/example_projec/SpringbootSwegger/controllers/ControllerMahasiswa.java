package com.example_projec.SpringbootSwegger.controllers;

import com.example_projec.SpringbootSwegger.models.Mahasiswa;
import com.example_projec.SpringbootSwegger.services.MahasiswaService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mahasiswa")
public class ControllerMahasiswa {

    @Autowired
    private MahasiswaService mahasiswaService;

    @GetMapping
    public List<Mahasiswa> getAll() {return mahasiswaService.getAll();
    }

    @GetMapping("/{nim}")
    public Mahasiswa getByNim(@PathVariable Long nim) {
        return mahasiswaService.getByNim(nim);
    }

    @PostMapping
    public Mahasiswa addMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        mahasiswaService.addMahasiswa(mahasiswa);
        return mahasiswa;
    }

    @PutMapping("")
    public Mahasiswa updateMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        mahasiswaService.updateMahasiswa(mahasiswa);
        return mahasiswa;
    }

    @DeleteMapping("/{nim}")
    public Mahasiswa deleteMahasiswa(@PathVariable Long nim) {
        Mahasiswa dt = mahasiswaService.getByNim(nim);
        if(dt != null){
            mahasiswaService.deleteMahasiswa(nim);
        }
        return dt;
    }

}


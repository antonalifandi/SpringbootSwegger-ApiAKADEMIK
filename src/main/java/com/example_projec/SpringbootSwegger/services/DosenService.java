package com.example_projec.SpringbootSwegger.services;

import com.example_projec.SpringbootSwegger.models.Dosen;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public interface DosenService {
    public List<Dosen> getAll();
    Dosen getByNip(Long nip);
    Dosen addDosen(Dosen dosen);
    void updateDosen(Long nip, Dosen dosen);
    String deleteDosen(Long nip);
}


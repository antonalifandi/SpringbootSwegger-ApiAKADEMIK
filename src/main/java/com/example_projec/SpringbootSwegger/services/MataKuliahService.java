package com.example_projec.SpringbootSwegger.services;

import com.example_projec.SpringbootSwegger.models.MataKuliah;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public interface MataKuliahService {
    public List<MataKuliah> getAll();
    MataKuliah getById(Long id);
    MataKuliah addMataKuliah(MataKuliah matakuliah);
    void updateMataKuliah(Long id, MataKuliah matakuliah);
    String deleteMataKuliah(Long id);

}

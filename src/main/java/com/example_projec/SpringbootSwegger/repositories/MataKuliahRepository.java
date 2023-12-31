package com.example_projec.SpringbootSwegger.repositories;

import com.example_projec.SpringbootSwegger.models.Mahasiswa;
import com.example_projec.SpringbootSwegger.models.MataKuliah;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Transactional
public interface MataKuliahRepository extends JpaRepository<MataKuliah, Long> {
    @Query("SELECT mk from MataKuliah mk ")
    List<MataKuliah> getAllData();

    @Query("SELECT mk FROM MataKuliah mk WHERE mk.id = :id")
    MataKuliah getById(Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM MataKuliah mk WHERE mk.id = :id")
    void deleteById(@Param("id") Long id);
}

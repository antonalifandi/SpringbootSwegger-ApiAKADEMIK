package com.example_projec.SpringbootSwegger.repositories;

import com.example_projec.SpringbootSwegger.models.Dosen;
import com.example_projec.SpringbootSwegger.models.Jadwal;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface JadwalRepository extends JpaRepository<Jadwal, Long> {
    @Query("SELECT jdl from Jadwal jdl ")
    List<Jadwal> getAll();

    @Query("SELECT jdl from Jadwal jdl WHERE jdl.id = :id")
    Jadwal getById(Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Jadwal jdl WHERE jdl.id = :id")
    void deleteById(@Param("id") Long id);

}

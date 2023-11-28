package com.example_projec.SpringbootSwegger.repositories;

import com.example_projec.SpringbootSwegger.models.Mahasiswa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Transactional
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {

    @Query("SELECT m from Mahasiswa m ")
    List<Mahasiswa> getAllData();

    @Query("SELECT m FROM Mahasiswa m WHERE m.nim = :nim")
    Mahasiswa getByNim(Long nim);

    @Modifying
    @Transactional
    @Query("DELETE FROM Mahasiswa m WHERE m.nim = :nim")
    void deleteByNim(@Param("nim") Long nim);









}

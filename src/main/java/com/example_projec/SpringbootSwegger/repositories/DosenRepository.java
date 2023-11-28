package com.example_projec.SpringbootSwegger.repositories;

import com.example_projec.SpringbootSwegger.models.Dosen;
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
public interface DosenRepository extends JpaRepository<Dosen, Long> {

    @Query("SELECT dsn from Dosen dsn ")
    List<Dosen> getAllData();

    @Query("SELECT dsn FROM Dosen dsn WHERE dsn.nip = :nip")
    Dosen getByNip(Long nip);

    @Modifying
    @Transactional
    @Query("DELETE FROM Dosen dsn WHERE dsn.nip = :nip")
    void deleteByNip(@Param("nip") Long nip);

}
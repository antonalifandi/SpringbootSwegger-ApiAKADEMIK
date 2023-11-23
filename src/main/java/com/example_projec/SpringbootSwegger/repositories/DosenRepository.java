package com.example_projec.SpringbootSwegger.repositories;

import com.example_projec.SpringbootSwegger.models.Dosen;
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

    @Modifying
    @Query("Update Dosen d SET d.deleted_flag = 1  WHERE d.nip=:id")
    void deleteDosen( @Param("id") Long id);

    @Query("SELECT new com.example_projec.SpringbootSwegger.models.Dosen(d.nip, d.nama, d.tgl_lahir, d.alamat, d.email, d.telpon) FROM Dosen d WHERE d.deleted_flag <> :deleted_flag")
    List<Dosen> findByDeletedFlagNot(@Param("deleted_flag") int deleted_flag);
}
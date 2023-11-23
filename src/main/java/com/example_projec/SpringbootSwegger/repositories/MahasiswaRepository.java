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
    @Modifying
   @Query("Update Mahasiswa m SET m.deleted_flag = 1  WHERE m.nim=:id")
    void deleteMahasiswa( @Param("id") Long id);

    @Query("SELECT new com.example_projec.SpringbootSwegger.models.Mahasiswa(m.nim, m.nama, m.tgl_lahir, m.alamat_mhs, m.email, m.telpon) FROM Mahasiswa m WHERE m.deleted_flag <> :deleted_flag")
    List<Mahasiswa> findByDeletedFlagNot(@Param("deleted_flag") int deleted_flag);




}

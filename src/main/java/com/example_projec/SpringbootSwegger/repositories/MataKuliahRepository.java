package com.example_projec.SpringbootSwegger.repositories;

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
    @Modifying
    @Query("Update MataKuliah mk SET mk.deleted_flag = 1  WHERE mk.id=:id")
    void deleteMataKuliah( @Param("id") Long id);

    @Query("SELECT new com.example_projec.SpringbootSwegger.models.MataKuliah(mk.id, mk.nama_matkul, mk.sks, mk.kode) FROM MataKuliah mk WHERE mk.deleted_flag <> :deleted_flag")
    List<MataKuliah> findByDeletedFlagNot(@Param("deleted_flag") int deleted_flag);
}

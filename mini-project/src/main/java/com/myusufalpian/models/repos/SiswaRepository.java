package com.myusufalpian.models.repos;

import com.myusufalpian.models.entities.KehadiranEntity;
import com.myusufalpian.models.entities.SiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.List;

public interface SiswaRepository extends JpaRepository<SiswaEntity, String> {

    public SiswaEntity findByNama(@PathParam("nama") String nama);

    public List<SiswaEntity> findByNamaStartingWith(@PathParam("nama") String nama);

    @Query("SELECT s FROM SiswaEntity s WHERE :kehadiranEntity MEMBER OF s.kehadiran")
    public List<SiswaEntity> findByKehadiran(@PathParam("id") KehadiranEntity kehadiranEntity);
}

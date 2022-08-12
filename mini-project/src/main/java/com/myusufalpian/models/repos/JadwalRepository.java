package com.myusufalpian.models.repos;

import com.myusufalpian.models.entities.JadwalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.websocket.server.PathParam;

public interface JadwalRepository extends JpaRepository<JadwalEntity, Integer> {
    public JadwalEntity findByHari(@PathParam("hari") String hari);
    public JadwalEntity findByWaktu(@PathParam("waktu") String waktu);
}

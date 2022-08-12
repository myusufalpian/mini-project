package com.myusufalpian.models.repos;

import com.myusufalpian.models.entities.PelajaranEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.websocket.server.PathParam;
import java.util.List;

public interface PelajaranRepository extends JpaRepository<PelajaranEntity, Integer> {
    public PelajaranEntity findByNama(@PathParam("nama") String nama);
    public List<PelajaranEntity> findByNamaStartingWith(@PathParam("nama") String nama);
}
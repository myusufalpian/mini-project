package com.myusufalpian.models.repos;

import com.myusufalpian.models.entities.GuruEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuruRepository extends JpaRepository<GuruEntity, String> {

    GuruEntity findByNama(String nama);
}

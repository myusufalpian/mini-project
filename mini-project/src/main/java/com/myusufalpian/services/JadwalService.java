package com.myusufalpian.services;

import com.myusufalpian.models.entities.JadwalEntity;
import com.myusufalpian.models.repos.JadwalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class JadwalService {

    @Autowired
    private JadwalRepository jadwalRepository;

    public JadwalEntity save(JadwalEntity jadwalEntity){
        return jadwalRepository.save(jadwalEntity);
    }

    public JadwalEntity findOne(int id){
        Optional<JadwalEntity> jadwalEntity = jadwalRepository.findById(id);
        if(!jadwalEntity.isPresent()){
            return null;
        }
        return jadwalEntity.get();
    }

    public Iterable<JadwalEntity> findAll(){
        return jadwalRepository.findAll();
    }

    public void removeOne(int id){
        jadwalRepository.deleteById(id);
    }

    public JadwalEntity getDataByHari(String hari){
        return jadwalRepository.findByHari(hari);
    }

    public JadwalEntity getDataByWaktu(String waktu){
        return jadwalRepository.findByWaktu(waktu);
    }
}

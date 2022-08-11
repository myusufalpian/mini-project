package com.myusufalpian.services;

import com.myusufalpian.models.entities.GuruEntity;
import com.myusufalpian.models.repos.GuruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class GuruService {
    @Autowired
    private GuruRepository guruRepository;

    public GuruEntity save(GuruEntity guruEntity){
        return guruRepository.save(guruEntity);
    }

    public GuruEntity findOne(String nip){
        Optional<GuruEntity> guruEntity = guruRepository.findById(nip);
        if(!guruEntity.isPresent()){
            return null;
        }
        return guruEntity.get();
    }

    public Iterable<GuruEntity> findAll(){
        return guruRepository.findAll();
    }

    public void removeOne(String nip){
        guruRepository.deleteById(nip);
    }

    public GuruEntity getDataByNama(String nama){
        return guruRepository.findByNama(nama);
    }
}

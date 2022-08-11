package com.myusufalpian.services;

import com.myusufalpian.models.entities.KehadiranEntity;
import com.myusufalpian.models.repos.KehadiranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class KehadiranService {

    @Autowired
    private KehadiranRepository kehadiranRepository;

    public KehadiranEntity save(KehadiranEntity kehadiranEntity){
        return kehadiranRepository.save(kehadiranEntity);
    }

    public KehadiranEntity findOne(int id){
        Optional<KehadiranEntity> kehadiranEntity = kehadiranRepository.findById(id);
        if(!kehadiranEntity.isPresent()){
            return null;
        }
        return kehadiranEntity.get();
    }

    public Iterable<KehadiranEntity> findAll(){
        return kehadiranRepository.findAll();
    }

    public void removeOne(int id){
        kehadiranRepository.deleteById(id);
    }
}

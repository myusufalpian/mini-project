package com.myusufalpian.services;

import com.myusufalpian.models.entities.KelasEntity;
import com.myusufalpian.models.repos.KelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class KelasService {

    @Autowired
    private KelasRepository kelasRepository;

    public KelasEntity save(KelasEntity kelasEntity){
        return kelasRepository.save(kelasEntity);
    }

    public KelasEntity findOne(long id){
        Optional<KelasEntity> kelasEntity = kelasRepository.findById(id);
        if(!kelasEntity.isPresent()){
            return null;
        }
        return kelasEntity.get();
    }

    public Iterable<KelasEntity> findAll(){
        return kelasRepository.findAll();
    }

    public void removeOne(long id){
        kelasRepository.deleteById(id);
    }
}

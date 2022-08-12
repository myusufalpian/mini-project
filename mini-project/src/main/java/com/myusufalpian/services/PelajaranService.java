package com.myusufalpian.services;

import com.myusufalpian.models.entities.PelajaranEntity;
import com.myusufalpian.models.entities.SiswaEntity;
import com.myusufalpian.models.repos.PelajaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PelajaranService {
    @Autowired
    private PelajaranRepository pelajaranRepository;

    public PelajaranEntity save(PelajaranEntity pelajaranEntity){
        return pelajaranRepository.save(pelajaranEntity);
    }

    public PelajaranEntity findOne(int id){
        Optional<PelajaranEntity> pelajaranEntity = pelajaranRepository.findById(id);
        if(!pelajaranEntity.isPresent()){
            return null;
        }
        return pelajaranEntity.get();
    }

    public Iterable<PelajaranEntity> findAll(){
        return pelajaranRepository.findAll();
    }

    public void removeOne(int id){
        pelajaranRepository.deleteById(id);
    }

    public PelajaranEntity getDataByNama(String nama){
        return pelajaranRepository.findByNama(nama);
    }

    public List<PelajaranEntity> getPelajaranByNama(String nama){
        return pelajaranRepository.findByNamaStartingWith(nama);
    }
}

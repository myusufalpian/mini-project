package com.myusufalpian.services;

import com.myusufalpian.models.entities.KehadiranEntity;
import com.myusufalpian.models.entities.SiswaEntity;
import com.myusufalpian.models.repos.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SiswaService {

    @Autowired
    private SiswaRepository siswaRepository;

    @Autowired
    private KehadiranService kehadiranService;

    public SiswaEntity save(SiswaEntity siswaEntity){
        return siswaRepository.save(siswaEntity);
    }

    public SiswaEntity findOne(String nis){
        Optional<SiswaEntity> siswaEntity = siswaRepository.findById(nis);
        if(!siswaEntity.isPresent()){
            return null;
        }
        return siswaEntity.get();
    }

    public Iterable<SiswaEntity> findAll(){
        return siswaRepository.findAll();
    }

    public void removeOne(String nip){
        siswaRepository.deleteById(nip);
    }

    public SiswaEntity getDataByNama(String nama){
        return siswaRepository.findByNama(nama);
    }

    public List<SiswaEntity> getSiswaByNama(String nama){
        return siswaRepository.findByNamaStartingWith(nama);
    }

    public List<SiswaEntity> getSiswaByKehadiran(int id){
        KehadiranEntity kehadiranEntity = kehadiranService.findOne(id);
        if (kehadiranEntity == null){
            return new ArrayList<SiswaEntity>();
        }
        return siswaRepository.findByKehadiran(kehadiranEntity);
    }

}

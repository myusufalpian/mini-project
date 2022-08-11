package com.myusufalpian.controllers;

import com.myusufalpian.services.SiswaService;
import com.myusufalpian.dto.ResponseData;
import com.myusufalpian.dto.SearchData;
import com.myusufalpian.models.entities.SiswaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/public/siswa")
public class SiswaController {

    @Autowired
    private SiswaService siswaService;

    @PostMapping(value = "addNewSiswa")
    public ResponseEntity<ResponseData<SiswaEntity>> save(@Valid @RequestBody SiswaEntity param, Errors errors) {

        ResponseData<SiswaEntity> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError objectError : errors.getAllErrors()){
                responseData.getMessages().add(objectError.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(siswaService.save(param));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping(value = "getAllData")
    public Iterable<SiswaEntity> findAll(){
        return siswaService.findAll();
    }

    @GetMapping(value = "getByNis")
    public SiswaEntity getByNis(@RequestParam String nis){
        return siswaService.findOne(nis);
    }

    @PutMapping(value = "updateData")
    public ResponseEntity<ResponseData<SiswaEntity>> updateData(@Valid @RequestBody SiswaEntity param, Errors errors){
        ResponseData<SiswaEntity> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError objectError : errors.getAllErrors()){
                responseData.getMessages().add(objectError.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(siswaService.save(param));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping(value = "deleteData")
    public Iterable<SiswaEntity> deleteData(@RequestParam String nis){
        siswaService.removeOne(nis);
        return siswaService.findAll();
    }

    @PostMapping(value = "getDataByNama")
    public SiswaEntity getDataByNama(@RequestBody SearchData searchData){
        return siswaService.getDataByNama(searchData.getKeyword());
    }

    @PostMapping(value = "getSiswaByNama")
    public List<SiswaEntity> getSiswaByNama(@RequestBody SearchData searchData){
        return siswaService.getSiswaByNama(searchData.getKeyword());
    }

    @GetMapping(value = "getSiswaByKehadiran")
    public List<SiswaEntity> getSiswaByKehadiran(@RequestParam int id){
        return siswaService.getSiswaByKehadiran(id);
    }

}

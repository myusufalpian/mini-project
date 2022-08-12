package com.myusufalpian.controllers;

import com.myusufalpian.dto.ResponseData;
import com.myusufalpian.dto.SearchData;
import com.myusufalpian.models.entities.JadwalEntity;
import com.myusufalpian.services.JadwalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/public/jadwal")
public class JadwalController {
    @Autowired
    private JadwalService jadwalService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "addNewJadwal")
    public ResponseEntity<ResponseData<JadwalEntity>> save(@Valid @RequestBody JadwalEntity jadwalEntity, Errors errors){
        ResponseData<JadwalEntity> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(jadwalService.save(jadwalEntity));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping(value = "getAllData")
    public Iterable<JadwalEntity> findAll(){
        return jadwalService.findAll();
    }

    @GetMapping(value = "getById")
    public JadwalEntity getById(@RequestParam int id){
        return jadwalService.findOne(id);
    }

    @PutMapping(value = "updateData")
    public ResponseEntity<ResponseData<JadwalEntity>> updateData(@Valid @RequestBody JadwalEntity jadwalEntity, Errors errors){
        ResponseData<JadwalEntity> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(jadwalService.save(jadwalEntity));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping(value = "deleteData")
    public Iterable<JadwalEntity> deleteData(@RequestParam int id){
        jadwalService.removeOne(id);
        return jadwalService.findAll();
    }

    @PostMapping(value = "getDataByHari")
    public JadwalEntity getDataByHari(@RequestBody SearchData searchData){
        return jadwalService.getDataByHari(searchData.getKeyword());
    }

    @PostMapping(value = "getDataByWaktu")
    public JadwalEntity getDataByWaktu(@RequestBody SearchData searchData){
        return jadwalService.getDataByWaktu(searchData.getKeyword());
    }
}

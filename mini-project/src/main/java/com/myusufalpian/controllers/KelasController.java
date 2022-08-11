package com.myusufalpian.controllers;

import com.myusufalpian.dto.ResponseData;
import com.myusufalpian.models.entities.KelasEntity;
import com.myusufalpian.services.KelasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/public/kelas")
public class KelasController {

    @Autowired
    private KelasService kelasService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "addNewKelas")
    public ResponseEntity<ResponseData<KelasEntity>> save(@Valid @RequestBody KelasEntity kelasEntity, Errors errors){
        ResponseData<KelasEntity> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(kelasService.save(kelasEntity));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping(value = "getAllData")
    public Iterable<KelasEntity> findAll(){
        return kelasService.findAll();
    }

    @GetMapping(value = "getById")
    public KelasEntity getByNip(@RequestParam int id){
        return kelasService.findOne(id);
    }

    @PutMapping(value = "updateData")
    public ResponseEntity<ResponseData<KelasEntity>> updateData(@Valid @RequestBody KelasEntity kelasEntity, Errors errors){
        ResponseData<KelasEntity> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(kelasService.save(kelasEntity));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping(value = "deleteData")
    public Iterable<KelasEntity> deleteData(@RequestParam int id){
        kelasService.removeOne(id);
        return kelasService.findAll();
    }
}

package com.myusufalpian.controllers;

import com.myusufalpian.dto.ResponseData;
import com.myusufalpian.services.KehadiranService;
import com.myusufalpian.models.entities.KehadiranEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/public/kehadiran")
public class KehadiranController {

    @Autowired
    private KehadiranService kehadiranService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "addNewKehadiran")
    public ResponseEntity<ResponseData<KehadiranEntity>> save(@Valid @RequestBody KehadiranEntity kehadiranEntity, Errors errors){
        ResponseData<KehadiranEntity> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(kehadiranService.save(kehadiranEntity));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping(value = "getAllData")
    public Iterable<KehadiranEntity> findAll(){
        return kehadiranService.findAll();
    }

    @GetMapping(value = "getById")
    public KehadiranEntity getById(@RequestParam int id){
        return kehadiranService.findOne(id);
    }

    @PutMapping(value = "updateData")
    public ResponseEntity<ResponseData<KehadiranEntity>> updateData(@Valid @RequestBody KehadiranEntity kehadiranEntity, Errors errors){
        ResponseData<KehadiranEntity> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(kehadiranService.save(kehadiranEntity));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping(value = "deleteData")
    public Iterable<KehadiranEntity> deleteData(@RequestParam int id){
        kehadiranService.removeOne(id);
        return kehadiranService.findAll();
    }
}

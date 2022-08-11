package com.myusufalpian.controllers;

import com.myusufalpian.dto.ResponseData;
import com.myusufalpian.dto.SearchData;
import com.myusufalpian.models.entities.GuruEntity;
import com.myusufalpian.services.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/public/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;

    @PostMapping(value = "addNewGuru")
    public ResponseEntity<ResponseData<GuruEntity>> save(@Valid @RequestBody GuruEntity param, Errors errors){
        ResponseData<GuruEntity> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError objectError : errors.getAllErrors()){
                responseData.getMessages().add(objectError.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(guruService.save(param));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping(value = "getAllData")
    public Iterable<GuruEntity> findAll(){
        return guruService.findAll();
    }

    @GetMapping(value = "getByNip")
    public GuruEntity getByNip(@RequestParam String nip){
        return guruService.findOne(nip);
    }

    @PutMapping(value = "updateData")
    public ResponseEntity<ResponseData<GuruEntity>> updateData(@Valid @RequestBody GuruEntity param, Errors errors){
        ResponseData<GuruEntity> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError objectError : errors.getAllErrors()){
                responseData.getMessages().add(objectError.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(guruService.save(param));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping(value = "deleteData")
    public Iterable<GuruEntity> deleteData(@RequestParam String nip){
        guruService.removeOne(nip);
        return guruService.findAll();
    }

    @PostMapping(value = "getDataByNama")
    public GuruEntity getDataByNama(@RequestBody SearchData searchData){
        return guruService.getDataByNama(searchData.getKeyword());
    }
}

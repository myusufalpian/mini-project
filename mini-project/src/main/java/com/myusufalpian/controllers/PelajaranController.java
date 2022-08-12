package com.myusufalpian.controllers;

import com.myusufalpian.dto.ResponseData;
import com.myusufalpian.dto.SearchData;
import com.myusufalpian.models.entities.PelajaranEntity;
import com.myusufalpian.models.entities.SiswaEntity;
import com.myusufalpian.services.PelajaranService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/public/pelajaran")
public class PelajaranController {
    @Autowired
    private PelajaranService pelajaranService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "addNewPelajaran")
    public ResponseEntity<ResponseData<PelajaranEntity>> save(@Valid @RequestBody PelajaranEntity pelajaranEntity, Errors errors){
        ResponseData<PelajaranEntity> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(pelajaranService.save(pelajaranEntity));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping(value = "getAllData")
    public Iterable<PelajaranEntity> findAll(){
        return pelajaranService.findAll();
    }

    @GetMapping(value = "getById")
    public PelajaranEntity getById(@RequestParam int id){
        return pelajaranService.findOne(id);
    }

    @PutMapping(value = "updateData")
    public ResponseEntity<ResponseData<PelajaranEntity>> updateData(@Valid @RequestBody PelajaranEntity pelajaranEntity, Errors errors){
        ResponseData<PelajaranEntity> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(pelajaranService.save(pelajaranEntity));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping(value = "deleteData")
    public Iterable<PelajaranEntity> deleteData(@RequestParam int id){
        pelajaranService.removeOne(id);
        return pelajaranService.findAll();
    }

    @PostMapping(value = "geDataByNama")
    public PelajaranEntity geDataByNama(@RequestBody SearchData searchData){
        return pelajaranService.getDataByNama(searchData.getKeyword());
    }

    @PostMapping(value = "getPelajaranByNama")
    public List<PelajaranEntity> getPelajaranByNama(@RequestBody SearchData searchData){
        return pelajaranService.getPelajaranByNama(searchData.getKeyword());
    }
}

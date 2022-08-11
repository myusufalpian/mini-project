package com.myusufalpian.controllers;

import com.myusufalpian.dto.ResponseData;
import com.myusufalpian.services.AppUserService;
import com.myusufalpian.models.entities.AppUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "register")
    public ResponseEntity<ResponseData<AppUser>> register(@RequestBody AppUser appUser, Errors errors){

        ResponseData<AppUser> responseData = new ResponseData<>();
//        AppUser appUser = modelMapper.map(userData, AppUser.class);
        responseData.setPayload(appUserService.registerAppUser(appUser));
        responseData.setStatus(true);
        responseData.getMessages().add("User has been registered!");
        return ResponseEntity.ok(responseData);
    }
}

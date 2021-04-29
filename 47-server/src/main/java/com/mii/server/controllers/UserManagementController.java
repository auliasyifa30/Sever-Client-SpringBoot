/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dtos.DataLoginDTO;
import com.mii.server.dtos.LoginDTO;
import com.mii.server.dtos.UserManagementDTO;

import com.mii.server.services.UserDetailService;
import com.mii.server.services.UserManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class UserManagementController {
    
    @Autowired
    UserManagementService userManagementService;
    
    @Autowired
    UserDetailService userDetailService;
    
    @PostMapping("/registrasi")
    public String insert(@RequestBody UserManagementDTO userManagementDTO){
        userManagementService.insertData(userManagementDTO);
        return "Data berhasil ditambahkan";
    }
    
    @GetMapping("/user")
    public String username() {
        return userDetailService.loadByUserName("aul_11", "aul123");
    }
    
    @PostMapping("/login")
    public LoginDTO loginDTO(@RequestBody DataLoginDTO dataLoginDTO) {
        return userDetailService.loginDTO(userDetailService.loadByUserName(
                dataLoginDTO.getUserName(), dataLoginDTO.getUserPassword()));
    }
    
    
    
}

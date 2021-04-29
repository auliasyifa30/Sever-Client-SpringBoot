/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dtos.EmployeeAddressDTO;
import com.mii.server.dtos.UserManagementDTO;
import com.mii.server.entities.Employees;
import com.mii.server.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ROG
 */
@RestController
@ResponseBody
@RequestMapping("employees")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    
    @GetMapping("")
    public List<Employees> selectAll() {
        return employeeService.getAll();
    }
    
    
    @GetMapping("employeeaddress")
    public List<EmployeeAddressDTO> showEmpAddr() {
        return employeeService.getDto();
    }
    
    @PostMapping("test")
    public String show(@RequestBody UserManagementDTO userManagementDTO) {
        return "halo";
    }
    
}

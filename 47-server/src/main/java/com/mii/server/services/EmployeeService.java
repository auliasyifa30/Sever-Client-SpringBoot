/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.EmployeeAddressDTO;
import com.mii.server.entities.Addresses;
import com.mii.server.entities.Employees;
import com.mii.server.repositories.EmployeeRepository;
import com.mii.server.repositories.ProvinceRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ROG
 */
@Service
public class EmployeeService {
    
    EmployeeRepository employeeRepository;
    
    @Autowired
    ProvinceRepository provinceRepository;

            
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    //Get All Data (SELECT)
    public List<Employees> getAll() {
        return employeeRepository.findAll();
    }
    
    //Read Dto
    public List<EmployeeAddressDTO> getDto() {
        List<Employees> emp = employeeRepository.findAll();
        
        List<EmployeeAddressDTO> ead = new ArrayList<>();
        
        for(Employees e : emp) {
            EmployeeAddressDTO ea = new EmployeeAddressDTO(
                    e.getEmployeeName(), 
                    e.getAddresses().getStreet1(), 
                    e.getAddresses().getVillageId().getVillageName(),
                    e.getAddresses().getVillageId().getSubdistrictId().getSubdistrictName(),
                    e.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getDistrictName(),
                    e.getAddresses().getVillageId().getSubdistrictId().getDistrictId().getProvinceId().getProvinceName()
            );
            ead.add(ea);
        }
        return ead;
    }
    
    
    //Insert New Employee
    public boolean insertNewEmployee() {
        return true;
        
    }
}

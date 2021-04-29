
package com.mii.server.services;

import com.mii.server.dtos.UserManagementDTO;
import com.mii.server.entities.Addresses;
import com.mii.server.entities.Contacts;
import com.mii.server.entities.Educations;
import com.mii.server.entities.Employees;
import com.mii.server.entities.Majors;
import com.mii.server.entities.Role;
import com.mii.server.entities.Universities;
import com.mii.server.entities.Users;
import com.mii.server.entities.Villages;
import com.mii.server.repositories.UserManagementRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {
    
    @Autowired
    UserManagementRepository userManagementRepository;
    
    @Autowired 
    PasswordEncoder passwordEncoder;
    
    //Create data for Multiple Table
    public Employees insertData(UserManagementDTO userManagementDTO) {
        List<Role> role = new ArrayList<>();
        role.add(new Role(2,"trainer"));
        Employees reg = new Employees(
                userManagementDTO.getPrefix(), 
                userManagementDTO.getEmployeeId(), 
                userManagementDTO.getEmployeeName(), 
                userManagementDTO.getBirthDate(), 
                userManagementDTO.getGender(), 
                userManagementDTO.getEmail(),
                new Addresses(
                        userManagementDTO.getPrefix(), 
                        userManagementDTO.getEmployeeId(), 
                        new Villages(userManagementDTO.getVillageId())
                ), 
                new Educations(
                        userManagementDTO.getEmployeeId(), 
                        new Majors(userManagementDTO.getMajorId()
                        ), 
                        new Universities(userManagementDTO.getUniversityId()
                        ),
                        userManagementDTO.getPrefix()
                ), 
                new Contacts(
                        userManagementDTO.getEmployeeId(), 
                        userManagementDTO.getPhone(), 
                        userManagementDTO.getLinkedin(), 
                        userManagementDTO.getPrefix()
                ),
                new Users (
                    userManagementDTO.getEmployeeId(),
                    userManagementDTO.getUserName(),
                    passwordEncoder.encode(userManagementDTO.getUserPassword()), role
                )
        );
        return userManagementRepository.save(reg);
    }
}

/**
{
    "prefix" : "MCC",
    "employeeId" : 20,
    "employeeName" : "Appan aja dah",
    "birthDate" : "1990-09-02",
    "gender" : "Laki-laki",
    "email" : "apaanaja@gmail.com",
    "villageId" : 5,
    "majorId" : 9,
    "universityId" : 4,
    "phone" : "09080877",
    "linkedin" : "linkedin_hhaaa",
    "userName" : "apaan",
    "userPassword" : "admin"
}
* 
* */
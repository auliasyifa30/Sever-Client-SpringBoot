/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.repositories;

import com.mii.server.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ROG
 */
public interface UserManagementRepository extends JpaRepository<Employees, Integer>{
    
}

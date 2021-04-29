/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.repositories;

import com.mii.server.entities.Districts;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ROG
 */
public interface DistrictRepository extends JpaRepository<Districts, Integer>{
    
}

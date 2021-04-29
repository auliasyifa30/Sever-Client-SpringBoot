/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.entities.Provinces;
import com.mii.server.repositories.ProvinceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProvinceService {
    
    ProvinceRepository provinceRepository;
    
    @Autowired
    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }
    
    //Create
    public void saveProvinces(Provinces provinces){
        provinceRepository.save(provinces);
    }
    
    //Read
    public List<Provinces> getAll() {
        return provinceRepository.findAll();
    }
    
    //Read Single Data
    public Provinces getByid(Integer id) {
        return provinceRepository.getOne(id);
    }
    
    //Update
    public void updateProvinceName(Integer id, Provinces province) {
        Provinces prov  = provinceRepository.getOne(id);
        prov.setProvinceName(province.getProvinceName());
        provinceRepository.save(prov);
    }
   
    //Delete
    public boolean deleteProvinceById(Integer id) {
        provinceRepository.deleteById(id);
        return provinceRepository.existsById(id);
    }

    public Provinces getProvinces(Integer id){
        return provinceRepository.findById(id).get();
    }
}

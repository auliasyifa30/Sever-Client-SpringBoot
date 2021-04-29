
package com.mii.server.controllers;

import com.mii.server.dtos.ProvinceDistrictDTO;
import com.mii.server.entities.Districts;
import com.mii.server.repositories.DistrictRepository;
import com.mii.server.repositories.ProvinceRepository;
import com.mii.server.services.DistrictService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistrictController {
    
    @Autowired
    DistrictService districtService;
    
    @Autowired
    ProvinceRepository provinceRepository;
    
    @Autowired
    DistrictRepository districtRepository;
    
    @Autowired
    public DistrictController (DistrictService  districtService){
        this.districtService = districtService;
    }
    
    //READ
    @GetMapping("/list-disprov") //DTO
    public List<ProvinceDistrictDTO> getProvinceDistrictDTOs(){
        return districtService.getProvinceDistrictName();
    }
    
    @GetMapping("/list-district") 
    public ResponseEntity<List<Districts>> getDistrict(){
        return new ResponseEntity<> (districtService.listAllDistricts(), HttpStatus.OK);
    }

    //get by id
    @GetMapping("/disget/{id}")
    public ResponseEntity<Districts> get(@PathVariable(value="id") Integer id) {
        try {
            Districts districts = districtService.getDistricts(id);
            return new ResponseEntity<>(districts,HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    //insert District Province sudah ada
    @PostMapping("/dis-insert")
    public ResponseEntity<Districts> insertDistrict(@RequestBody Districts districts){
        Districts districtsNew = districtService.saveDistricts(districts);
        return new ResponseEntity(districtsNew, HttpStatus.OK);
    }
    
    //update
    @PutMapping("/dis-update/{id}")
    public ResponseEntity<?> update(@RequestBody Districts districts, @PathVariable (value="id") Integer id) {
        try {
            Districts existDistricts = districtService.getDistricts(id);
            districts.setDistrictId(id);
            districts.setKotakab(districts.getKotakab());
            districts.setDistrictName(districts.getDistrictName());
            districts.setProvinceId(districts.getProvinceId());
            districtService.saveDistricts(districts);
            return new ResponseEntity<>("Data berhasil diubah", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    //delete
    @DeleteMapping("/dis-delete/{id}")
    public String delete(@PathVariable(value="id") Integer id) {
         districtService.deleteDistrict(id);
         return "Data berhasil dihapus";
    }
}

//{
//        "kotakab": "Kota",
//        "districtName": "Depok",
//        "provinceId": {
//            "provinceId": 4,
//            "provinceName": "Jawa Barat"
//        }
//    }

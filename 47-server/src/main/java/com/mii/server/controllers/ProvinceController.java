
package com.mii.server.controllers;

import com.mii.server.entities.Provinces;
import com.mii.server.services.ProvinceService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
//@RequestMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//@RequestMapping("provinces") //Request mapping ke tabel
public class ProvinceController {
    
    @Autowired
    ProvinceService provinceService;
    
    //GET
    @GetMapping("list-province")
    public List<Provinces> selectAll() {
        return provinceService.getAll();
    }
    
   //get by id 
    @GetMapping("/provinceBy/{id}")
    public ResponseEntity<Provinces> get(@PathVariable(value="id") Integer id) {
        try {
            Provinces provinces = provinceService.getProvinces(id);
            return new ResponseEntity<>(provinces, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
            
    //POST
    @PostMapping("/insert")
    public String insert(@RequestBody Provinces province) {
        provinceService.saveProvinces(province);
        return "Data berhasil ditambah";
    }
    
    //PUT
    @PutMapping("/update/{id}") //PUT OR PATCHH
    public String updateProvince(@PathVariable Integer id, @RequestBody Provinces province) {
        provinceService.getByid(id);
        provinceService.updateProvinceName(id, province);
        return "Data berhasil diubah";
    }
    
    //DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteProvince(@PathVariable Integer id) {
        provinceService.deleteProvinceById(id);
        return "Data berhasil dihapus";
    }
}
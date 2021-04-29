
package com.mii.server.services;

import com.mii.server.dtos.ProvinceDistrictDTO;
import com.mii.server.entities.Districts;
import com.mii.server.repositories.DistrictRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {
    
    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    //READ
    public List<Districts> listAllDistricts() {
        return districtRepository.findAll();
    }

    //CREATE
    public Districts saveDistricts(Districts districts) {
        return districtRepository.save(districts);
    }
    
    //READ BY ID
    public Districts getDistricts(Integer id) {
        return districtRepository.findById(id).get();
    }

    //DELETE
    public void deleteDistrict(Integer id) {
        districtRepository.deleteById(id);
    }

    //DTO
    public List<ProvinceDistrictDTO> getProvinceDistrictName() {
        districtRepository.findAll();
        List<ProvinceDistrictDTO> pds = new ArrayList<>();
        for (Districts d : districtRepository.findAll()) {
            ProvinceDistrictDTO pd = new ProvinceDistrictDTO(
                    d.getDistrictId(), 
                    d.getKotakab(), 
                    d.getDistrictName(),
                    d.getProvinceId().getProvinceName());
            pds.add(pd);
        }
        return pds;
    }
    
    
        
}


package com.mii.server.dtos;

import com.mii.server.entities.Provinces;

public class ProvinceDistrictDTO {
    private Integer districtId;
    private String kotakab; 
    private String districtName;
    private String provinceName;

    public ProvinceDistrictDTO() {
    }

    public ProvinceDistrictDTO(Integer districtId, String kotakab, String districtName, String provinceName) {
        this.districtId = districtId;
        this.kotakab = kotakab;
        this.districtName = districtName;
        this.provinceName = provinceName;
    }

    public ProvinceDistrictDTO(Integer districtId, String kotakab, String districtName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public Integer getDistrictId() {
        return districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getKotakab() {
        return kotakab;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public void setKotakab(String kotakab) {
        this.kotakab = kotakab;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

   

  
}

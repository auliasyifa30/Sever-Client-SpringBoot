/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.dtos;

/**
 *
 * @author ROG
 */
public class EmployeeAddressDTO {
    private String employeeName;
    private String street1;
    private String villageName;
    private String subDistrict;
    private String district;
    private String province;

    public EmployeeAddressDTO(String employeeName, String street1, String villageName, String subDistrict, String district, String province) {
        this.employeeName = employeeName;
        this.street1 = street1;
        this.villageName = villageName;
        this.subDistrict = subDistrict;
        this.district = district;
        this.province = province;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getStreet1() {
        return street1;
    }

    public String getVillageName() {
        return villageName;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public String getDistrict() {
        return district;
    }

    public String getProvince() {
        return province;
    }
    
    
    
    

    
    
}

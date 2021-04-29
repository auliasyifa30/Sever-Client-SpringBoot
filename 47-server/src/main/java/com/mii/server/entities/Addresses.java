/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ROG
 */
@Entity
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Addresses.findAll", query = "SELECT a FROM Addresses a")})
public class Addresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "prefix")
    private String prefix;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "address_id")
    private Integer addressId;
    @Column(name = "street1")
    private String street1;
    @JoinColumn(name = "address_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    private Employees employees;
    @JoinColumn(name = "village_id", referencedColumnName = "village_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Villages villageId;

    public Addresses() {
    }

    public Addresses(Integer addressId) {
        this.addressId = addressId;
    }
    
    public Addresses(Villages villageId) {
        this.villageId = villageId;
    }
    
    public Addresses(String prefix, Integer addressId, Villages villageId) {
        this.prefix = prefix;
        this.addressId = addressId;
        this.villageId = villageId;
    }

    public Addresses(Integer addressId, String prefix) {
        this.addressId = addressId;
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Villages getVillageId() {
        return villageId;
    }

    public void setVillageId(Villages villageId) {
        this.villageId = villageId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addresses)) {
            return false;
        }
        Addresses other = (Addresses) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.server.entities.Addresses[ addressId=" + addressId + " ]";
    }
    
}

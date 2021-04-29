/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ROG
 */
@Entity
@Table(name = "village")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Villages.findAll", query = "SELECT v FROM Villages v")})
public class Villages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "village_id")
    private Integer villageId;
    @Basic(optional = false)
    @Column(name = "village_name")
    private String villageName;
    @Basic(optional = false)
    @Column(name = "zip_code")
    private String zipCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "villageId", fetch = FetchType.LAZY)
    private List<Addresses> addressesList;
    @JoinColumn(name = "subdistrict_id", referencedColumnName = "subdistrict_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Subdistricts subdistrictId;

    public Villages() {
    }

    public Villages(Integer villageId) {
        this.villageId = villageId;
    }

    public Villages(Integer villageId, String villageName, String zipCode) {
        this.villageId = villageId;
        this.villageName = villageName;
        this.zipCode = zipCode;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @XmlTransient
    public List<Addresses> getAddressesList() {
        return addressesList;
    }

    public void setAddressesList(List<Addresses> addressesList) {
        this.addressesList = addressesList;
    }

    public Subdistricts getSubdistrictId() {
        return subdistrictId;
    }

    public void setSubdistrictId(Subdistricts subdistrictId) {
        this.subdistrictId = subdistrictId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (villageId != null ? villageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Villages)) {
            return false;
        }
        Villages other = (Villages) object;
        if ((this.villageId == null && other.villageId != null) || (this.villageId != null && !this.villageId.equals(other.villageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.server.entities.Villages[ villageId=" + villageId + " ]";
    }
    
}

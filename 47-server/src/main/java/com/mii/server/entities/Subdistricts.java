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
@Table(name = "subdistrict")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subdistricts.findAll", query = "SELECT s FROM Subdistricts s")})
public class Subdistricts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subdistrict_id")
    private Integer subdistrictId;
    @Basic(optional = false)
    @Column(name = "subdistrict_name")
    private String subdistrictName;
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Districts districtId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subdistrictId", fetch = FetchType.LAZY)
    private List<Villages> villagesList;

    public Subdistricts() {
    }

    public Subdistricts(Integer subdistrictId) {
        this.subdistrictId = subdistrictId;
    }

    public Subdistricts(Integer subdistrictId, String subdistrictName) {
        this.subdistrictId = subdistrictId;
        this.subdistrictName = subdistrictName;
    }

    public Integer getSubdistrictId() {
        return subdistrictId;
    }

    public void setSubdistrictId(Integer subdistrictId) {
        this.subdistrictId = subdistrictId;
    }

    public String getSubdistrictName() {
        return subdistrictName;
    }

    public void setSubdistrictName(String subdistrictName) {
        this.subdistrictName = subdistrictName;
    }

    public Districts getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Districts districtId) {
        this.districtId = districtId;
    }

    @XmlTransient
    public List<Villages> getVillagesList() {
        return villagesList;
    }

    public void setVillagesList(List<Villages> villagesList) {
        this.villagesList = villagesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subdistrictId != null ? subdistrictId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subdistricts)) {
            return false;
        }
        Subdistricts other = (Subdistricts) object;
        if ((this.subdistrictId == null && other.subdistrictId != null) || (this.subdistrictId != null && !this.subdistrictId.equals(other.subdistrictId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.server.entities.Subdistricts[ subdistrictId=" + subdistrictId + " ]";
    }
    
}

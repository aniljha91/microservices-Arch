package com.ccsp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PharmacyCategoryList generated by hbm2java
 */
@Entity
@Table(name = "PharmacyCategoryList")
public class PharmacyCategoryList implements java.io.Serializable {


  private int pharmacyCategoryId;
  private String pharmacyCategoryCode;
  private String pharmacyCategoryName;
  private String pharmacyCategoryDescription;

  public PharmacyCategoryList() {}

  public PharmacyCategoryList(int pharmacyCategoryId, String pharmacyCategoryCode,
      String pharmacyCategoryName, String pharmacyCategoryDescription) {
    this.pharmacyCategoryId = pharmacyCategoryId;
    this.pharmacyCategoryCode = pharmacyCategoryCode;
    this.pharmacyCategoryName = pharmacyCategoryName;
    this.pharmacyCategoryDescription = pharmacyCategoryDescription;
  }

  @Id


  @Column(name = "PharmacyCategoryID", unique = true, nullable = false)
  public int getPharmacyCategoryId() {
    return this.pharmacyCategoryId;
  }

  public void setPharmacyCategoryId(int pharmacyCategoryId) {
    this.pharmacyCategoryId = pharmacyCategoryId;
  }


  @Column(name = "PharmacyCategoryCode", nullable = false)
  public String getPharmacyCategoryCode() {
    return this.pharmacyCategoryCode;
  }

  public void setPharmacyCategoryCode(String pharmacyCategoryCode) {
    this.pharmacyCategoryCode = pharmacyCategoryCode;
  }


  @Column(name = "PharmacyCategoryName", nullable = false)
  public String getPharmacyCategoryName() {
    return this.pharmacyCategoryName;
  }

  public void setPharmacyCategoryName(String pharmacyCategoryName) {
    this.pharmacyCategoryName = pharmacyCategoryName;
  }


  @Column(name = "PharmacyCategoryDescription", nullable = false)
  public String getPharmacyCategoryDescription() {
    return this.pharmacyCategoryDescription;
  }

  public void setPharmacyCategoryDescription(String pharmacyCategoryDescription) {
    this.pharmacyCategoryDescription = pharmacyCategoryDescription;
  }



}



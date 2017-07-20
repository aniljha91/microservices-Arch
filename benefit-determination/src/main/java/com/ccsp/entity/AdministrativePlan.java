package com.ccsp.entity;



import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * AdministrativePlan generated by hbm2java
 */
@Entity
@Table(name = "AdministrativePlan",
    uniqueConstraints = @UniqueConstraint(columnNames = "AdminPlanId"))
public class AdministrativePlan implements java.io.Serializable {

  @Id
  @Column(name = "NodeId", columnDefinition = "BINARY(254)", length = 254, unique = true, nullable = false)
  private byte[] nodeId;
  private Short nodeLevel;
  private int adminPlanId;
  private String adminPlanName;
  private String benefiServiceTierName1;
  private String benefiServiceTierName2;
  private String benefiServiceTierName3;
  private String pharmacyTierName1;
  private String pharmacyTierName2;
  private String pharmacyTierName3;
  private int productTypeId;
  private int stateId;
  private int grandafatheredId;
  private String adminPlanEffDate;
  private String adminPlanEndDate;

  public AdministrativePlan() {}


  public AdministrativePlan(byte[] nodeId, int adminPlanId, String adminPlanName,
      String benefiServiceTierName1, String benefiServiceTierName2, String benefiServiceTierName3,
      String pharmacyTierName1, String pharmacyTierName2, String pharmacyTierName3,
      int productTypeId, int stateId, int grandafatheredId, String adminPlanEffDate) {
    this.nodeId = nodeId;
    this.adminPlanId = adminPlanId;
    this.adminPlanName = adminPlanName;
    this.benefiServiceTierName1 = benefiServiceTierName1;
    this.benefiServiceTierName2 = benefiServiceTierName2;
    this.benefiServiceTierName3 = benefiServiceTierName3;
    this.pharmacyTierName1 = pharmacyTierName1;
    this.pharmacyTierName2 = pharmacyTierName2;
    this.pharmacyTierName3 = pharmacyTierName3;
    this.productTypeId = productTypeId;
    this.stateId = stateId;
    this.grandafatheredId = grandafatheredId;
    this.adminPlanEffDate = adminPlanEffDate;
  }

  public AdministrativePlan(byte[] nodeId, Short nodeLevel, int adminPlanId, String adminPlanName,
      String benefiServiceTierName1, String benefiServiceTierName2, String benefiServiceTierName3,
      String pharmacyTierName1, String pharmacyTierName2, String pharmacyTierName3,
      int productTypeId, int stateId, int grandafatheredId, String adminPlanEffDate,
      String adminPlanEndDate) {
    this.nodeId = nodeId;
    this.nodeLevel = nodeLevel;
    this.adminPlanId = adminPlanId;
    this.adminPlanName = adminPlanName;
    this.benefiServiceTierName1 = benefiServiceTierName1;
    this.benefiServiceTierName2 = benefiServiceTierName2;
    this.benefiServiceTierName3 = benefiServiceTierName3;
    this.pharmacyTierName1 = pharmacyTierName1;
    this.pharmacyTierName2 = pharmacyTierName2;
    this.pharmacyTierName3 = pharmacyTierName3;
    this.productTypeId = productTypeId;
    this.stateId = stateId;
    this.grandafatheredId = grandafatheredId;
    this.adminPlanEffDate = adminPlanEffDate;
    this.adminPlanEndDate = adminPlanEndDate;
  }

  public byte[] getNodeId() {
    return this.nodeId;
  }

  public void setNodeId(byte[] nodeId) {
    this.nodeId = nodeId;
  }


  @Column(name = "NodeLevel")
  public Short getNodeLevel() {
    return this.nodeLevel;
  }

  public void setNodeLevel(Short nodeLevel) {
    this.nodeLevel = nodeLevel;
  }


  @Column(name = "AdminPlanId", unique = true, nullable = false)
  public int getAdminPlanId() {
    return this.adminPlanId;
  }

  public void setAdminPlanId(int adminPlanId) {
    this.adminPlanId = adminPlanId;
  }


  @Column(name = "AdminPlanName", nullable = false)
  public String getAdminPlanName() {
    return this.adminPlanName;
  }

  public void setAdminPlanName(String adminPlanName) {
    this.adminPlanName = adminPlanName;
  }


  @Column(name = "BenefiServiceTierName1", nullable = false)
  public String getBenefiServiceTierName1() {
    return this.benefiServiceTierName1;
  }

  public void setBenefiServiceTierName1(String benefiServiceTierName1) {
    this.benefiServiceTierName1 = benefiServiceTierName1;
  }


  @Column(name = "BenefiServiceTierName2", nullable = false)
  public String getBenefiServiceTierName2() {
    return this.benefiServiceTierName2;
  }

  public void setBenefiServiceTierName2(String benefiServiceTierName2) {
    this.benefiServiceTierName2 = benefiServiceTierName2;
  }


  @Column(name = "BenefiServiceTierName3", nullable = false)
  public String getBenefiServiceTierName3() {
    return this.benefiServiceTierName3;
  }

  public void setBenefiServiceTierName3(String benefiServiceTierName3) {
    this.benefiServiceTierName3 = benefiServiceTierName3;
  }


  @Column(name = "PharmacyTierName1", nullable = false)
  public String getPharmacyTierName1() {
    return this.pharmacyTierName1;
  }

  public void setPharmacyTierName1(String pharmacyTierName1) {
    this.pharmacyTierName1 = pharmacyTierName1;
  }


  @Column(name = "PharmacyTierName2", nullable = false)
  public String getPharmacyTierName2() {
    return this.pharmacyTierName2;
  }

  public void setPharmacyTierName2(String pharmacyTierName2) {
    this.pharmacyTierName2 = pharmacyTierName2;
  }


  @Column(name = "PharmacyTierName3", nullable = false)
  public String getPharmacyTierName3() {
    return this.pharmacyTierName3;
  }

  public void setPharmacyTierName3(String pharmacyTierName3) {
    this.pharmacyTierName3 = pharmacyTierName3;
  }


  @Column(name = "ProductTypeId", nullable = false)
  public int getProductTypeId() {
    return this.productTypeId;
  }

  public void setProductTypeId(int productTypeId) {
    this.productTypeId = productTypeId;
  }


  @Column(name = "StateId", nullable = false)
  public int getStateId() {
    return this.stateId;
  }

  public void setStateId(int stateId) {
    this.stateId = stateId;
  }


  @Column(name = "GrandafatheredId", nullable = false)
  public int getGrandafatheredId() {
    return this.grandafatheredId;
  }

  public void setGrandafatheredId(int grandafatheredId) {
    this.grandafatheredId = grandafatheredId;
  }


  @Column(name = "AdminPlanEffDate", nullable = false)
  public String getAdminPlanEffDate() {
    return this.adminPlanEffDate;
  }

  public void setAdminPlanEffDate(String adminPlanEffDate) {
    this.adminPlanEffDate = adminPlanEffDate;
  }


  @Column(name = "AdminPlanEndDate")
  public String getAdminPlanEndDate() {
    return this.adminPlanEndDate;
  }

  public void setAdminPlanEndDate(String adminPlanEndDate) {
    this.adminPlanEndDate = adminPlanEndDate;
  }



}



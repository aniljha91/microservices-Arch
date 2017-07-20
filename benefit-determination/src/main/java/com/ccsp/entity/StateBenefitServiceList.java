package com.ccsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * StateBenefitServiceList generated by hbm2java
 */
@Entity
@Table(name = "StateBenefitServiceList")
public class StateBenefitServiceList implements java.io.Serializable {


  private int stateBenefitServiceId;
  private int corporateBenefitServiceId;
  private int stateId;
  private String stateBenefitServiceCode;
  private String stateBenefitServiceName;
  private String stateBenefitServiceDescription;

  public StateBenefitServiceList() {}

  public StateBenefitServiceList(int stateBenefitServiceId, int corporateBenefitServiceId,
      int stateId, String stateBenefitServiceCode, String stateBenefitServiceName,
      String stateBenefitServiceDescription) {
    this.stateBenefitServiceId = stateBenefitServiceId;
    this.corporateBenefitServiceId = corporateBenefitServiceId;
    this.stateId = stateId;
    this.stateBenefitServiceCode = stateBenefitServiceCode;
    this.stateBenefitServiceName = stateBenefitServiceName;
    this.stateBenefitServiceDescription = stateBenefitServiceDescription;
  }

  @Id


  @Column(name = "StateBenefitServiceID", unique = true, nullable = false)
  public int getStateBenefitServiceId() {
    return this.stateBenefitServiceId;
  }

  public void setStateBenefitServiceId(int stateBenefitServiceId) {
    this.stateBenefitServiceId = stateBenefitServiceId;
  }


  @Column(name = "CorporateBenefitServiceID", nullable = false)
  public int getCorporateBenefitServiceId() {
    return this.corporateBenefitServiceId;
  }

  public void setCorporateBenefitServiceId(int corporateBenefitServiceId) {
    this.corporateBenefitServiceId = corporateBenefitServiceId;
  }


  @Column(name = "StateId", nullable = false)
  public int getStateId() {
    return this.stateId;
  }

  public void setStateId(int stateId) {
    this.stateId = stateId;
  }


  @Column(name = "StateBenefitServiceCode", nullable = false)
  public String getStateBenefitServiceCode() {
    return this.stateBenefitServiceCode;
  }

  public void setStateBenefitServiceCode(String stateBenefitServiceCode) {
    this.stateBenefitServiceCode = stateBenefitServiceCode;
  }


  @Column(name = "StateBenefitServiceName", nullable = false)
  public String getStateBenefitServiceName() {
    return this.stateBenefitServiceName;
  }

  public void setStateBenefitServiceName(String stateBenefitServiceName) {
    this.stateBenefitServiceName = stateBenefitServiceName;
  }


  @Column(name = "StateBenefitServiceDescription", nullable = false)
  public String getStateBenefitServiceDescription() {
    return this.stateBenefitServiceDescription;
  }

  public void setStateBenefitServiceDescription(String stateBenefitServiceDescription) {
    this.stateBenefitServiceDescription = stateBenefitServiceDescription;
  }



}



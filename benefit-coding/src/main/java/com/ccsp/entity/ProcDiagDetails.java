package com.ccsp.entity;
// default package
// Generated 14 Mar, 2017 8:23:39 PM by Hibernate Tools 5.0.2.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proc_diag_details", schema = "dbo", catalog = "ccsp")
public class ProcDiagDetails implements java.io.Serializable {


  private int id;
  private int diagCode;
  private int procCode;
  private int serviceCode;

  public ProcDiagDetails() {}


  public ProcDiagDetails(int id) {
    this.id = id;
  }

  public ProcDiagDetails(int id,int diagCode,int procCode, int serviceCode) {
    this.id = id;
    this.diagCode = diagCode;
    this.procCode = procCode;
    this.serviceCode = serviceCode;
  
  }

  @Id
  @Column(name = "id", unique = true, nullable = false)
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Column(name = "diag_code", unique = true, nullable = false)
public int getDiagCode() {
	return diagCode;
}


public void setDiagCode(int diagCode) {
	this.diagCode = diagCode;
}

@Column(name = "proc_code", unique = true, nullable = false)
public int getProcCode() {
	return procCode;
}


public void setProcCode(int procCode) {
	this.procCode = procCode;
}

@Column(name = "service_code", unique = true, nullable = false)
public int getServiceCode() {
	return serviceCode;
}


public void setServiceCode(int serviceCode) {
	this.serviceCode = serviceCode;
}









}



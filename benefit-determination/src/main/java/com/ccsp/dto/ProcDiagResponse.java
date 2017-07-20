/*
 * Copyright (c) 2016 Qualcomm Technologies, Inc.
 *All Rights Reserved.
 *Qualcomm Technologies, Inc. Confidential and Proprietary.

 *This software may be subject to U.S. and international export, re-export or
 *transfer ("export") laws.  Diversion contrary to U.S. and international law
 *is strictly prohibited.

 *QUALCOMM is a registered trademark of QUALCOMM Incorporated in the
 *United States and may be registered in other countries. Other product
 *and brand names may be trademarks or registered trademarks of their
 *respective owners.
 */

package com.ccsp.dto;

import java.util.List;

import com.ccsp.entity.Procedures;;

public class ProcDiagResponse {
  
  private Integer Id;
  private String name;
  private List<Procedures> proceduresList;
  public Integer getId() {
    return Id;
  }
  public String getName() {
    return name;
  }
  public List<Procedures> getProceduresList() {
    return proceduresList;
  }
  public void setId(Integer id) {
    Id = id;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setProceduresList(List<Procedures> proceduresList) {
    this.proceduresList = proceduresList;
  }
  

}

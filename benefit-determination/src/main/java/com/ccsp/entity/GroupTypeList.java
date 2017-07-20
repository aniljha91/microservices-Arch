package com.ccsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GroupTypeList generated by hbm2java
 */
@Entity
@Table(name = "GroupTypeList")
public class GroupTypeList implements java.io.Serializable {


  private int groupTypeId;
  private String groupTypeName;
  private String groupTypeDescription;

  public GroupTypeList() {}

  public GroupTypeList(int groupTypeId, String groupTypeName, String groupTypeDescription) {
    this.groupTypeId = groupTypeId;
    this.groupTypeName = groupTypeName;
    this.groupTypeDescription = groupTypeDescription;
  }

  @Id


  @Column(name = "GroupTypeId", unique = true, nullable = false)
  public int getGroupTypeId() {
    return this.groupTypeId;
  }

  public void setGroupTypeId(int groupTypeId) {
    this.groupTypeId = groupTypeId;
  }


  @Column(name = "GroupTypeName", nullable = false)
  public String getGroupTypeName() {
    return this.groupTypeName;
  }

  public void setGroupTypeName(String groupTypeName) {
    this.groupTypeName = groupTypeName;
  }


  @Column(name = "GroupTypeDescription", nullable = false)
  public String getGroupTypeDescription() {
    return this.groupTypeDescription;
  }

  public void setGroupTypeDescription(String groupTypeDescription) {
    this.groupTypeDescription = groupTypeDescription;
  }



}



package com.ccsp.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ccsp.dao.DiagnosticRepository;
import com.ccsp.dao.MemberRepository;
import com.ccsp.dao.PlanRepository;
import com.ccsp.dao.ProcedureRepository;
import com.ccsp.dto.ClaimRequest;
import com.ccsp.dto.ProcDiagResponse;
import com.ccsp.entity.Diagnostics;
import com.ccsp.entity.Members;
import com.ccsp.entity.Plans;
import com.ccsp.model.Claim;
import com.ccsp.service.CCSPService;

@Component
public class CCSPServiceImpl implements CCSPService {

  @Resource
  private MemberRepository memberRepository;


  @Resource
  private PlanRepository planRepository;
  
  @Resource
  private DiagnosticRepository diagnosticRepository;
  
  @Resource
  private ProcedureRepository procRepository;
  

 

  @Override
  public List<Members> getMemberList() {

    return memberRepository.findAll();
  }

  @Override
  public List<Plans> getPlanList() {

    return planRepository.findAll();
  }

  @Override
  public List<ProcDiagResponse> getDaignosticList() {
   
    List<ProcDiagResponse> response = new ArrayList<>();
    List<Diagnostics> daignosticList= diagnosticRepository.findAll();
    for(Diagnostics diag : daignosticList){
      ProcDiagResponse data= new ProcDiagResponse();
      data.setId(diag.getId());
      data.setName(diag.getName());
      data.setProceduresList(procRepository.findByDiagCode(diag.getId()));
      response.add(data);
    }
    
    return response;
  }

@Override
public Claim getClaimRules(ClaimRequest claimRequest) {
	Claim claim= new Claim();
	
	return claim;
}



}

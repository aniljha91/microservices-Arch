package com.ccsp.service;

import java.util.List;

import com.ccsp.dto.ClaimRequest;
import com.ccsp.dto.ProcDiagResponse;
import com.ccsp.entity.Members;
import com.ccsp.entity.Plans;
import com.ccsp.model.Claim;

public interface CCSPService {

  List<Members> getMemberList();

  List<Plans> getPlanList();

  List<ProcDiagResponse> getDaignosticList();

  Claim getClaimRules(ClaimRequest claimRequest);

}

package com.ccsp.dao;

import com.ccsp.dto.ClaimRequest;
import com.ccsp.model.Claim;


public interface ClaimDAO {

	Claim getRuleSet(ClaimRequest claimRequest);

	

}

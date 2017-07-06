package com.ccsp.dao;

import com.ccsp.dto.ClaimRequest;
import com.ccsp.model.Claim;
import com.ccsp.model.User;

public interface ClaimDAO {

	Claim getRuleSet(ClaimRequest claimRequest);

	

}

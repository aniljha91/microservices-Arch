package com.ccsp.service;


import com.ccsp.entity.AdminBenefitSvcCostShareOverrides;
import com.ccsp.entity.AdministrativePlanCostShareOverrides;
import com.ccsp.entity.BenefitServiceList;
import com.ccsp.entity.ClaimCostShareData;
import com.ccsp.entity.ClaimData;
import com.ccsp.entity.CorporateBenefitServiceList;
import com.ccsp.entity.CostShareList;
import com.ccsp.entity.GrandfatheredBenefitServiceList;
import com.ccsp.entity.GrandfatheredList;
import com.ccsp.entity.GroupTypeList;
import com.ccsp.entity.MarketingPlan;
import com.ccsp.entity.MemberAccumulatorData;
import com.ccsp.entity.MetallicList;
import com.ccsp.entity.NetworkBenefitServiceList;
import com.ccsp.entity.NetworkNameList;
import com.ccsp.entity.PharmacyCategoryList;
import com.ccsp.entity.PlanObjectHistory;
import com.ccsp.entity.ProcCodeDiagCodeList;
import com.ccsp.entity.ProductTypeList;
import com.ccsp.entity.StateBenefitServiceList;
import com.ccsp.entity.StateList;
import java.util.List;

public interface MasterService {



	void addState(StateList state);

	StateList getState(Integer stateId);

	void addCostShare(CostShareList costShare);

	void addStateBenifitDetails(StateBenefitServiceList stateBenefitServiceList);

	void addBenifitService(BenefitServiceList benefitServiceList);

	void addCorporateBenifitService(CorporateBenefitServiceList benefitService);

	void addNetworkBenifitService(NetworkBenefitServiceList benefitService);

	void addGrandFatheredBenefitService(GrandfatheredBenefitServiceList benefitService);

	void addAdminPlanCostShare(AdministrativePlanCostShareOverrides costShare);

	void addAdminBenefitCostShare(AdminBenefitSvcCostShareOverrides costShare);

	void addProcDiagCodes(ProcCodeDiagCodeList procDiagCodes);

	void addClaimCostShare(ClaimCostShareData costShareClaim);

	void addMemberAccumulator(MemberAccumulatorData accumulatorData);

	void addPlanHistory(PlanObjectHistory planHistory);

	void addMarketingPlan(MarketingPlan plan);

	void getCostShare(Integer id);

	void getBenifitService(Integer id);

	void deleteBenifitService(Integer id);

	void addCorporateBenifitService(Integer id);

	void deleteCorporateBenifitService(Integer id);

	void deleteNetworkBenifitService(Integer id);

	void getNetworkBenifitService(Integer id);

	void getGrandFatheredBenefitService(Integer id);

	void deleteGrandFatheredBenefitService(Integer id);

	void getStateBenifitDetails(Integer id);

	void deleteStateBenifitDetails(Integer id);

	void getAdminPlanCostShare(Integer id);

	void deleteAdminPlanCostShare(Integer id);
	
	
	void addNetworkName(NetworkNameList networkName);

	NetworkNameList getNetworkName(Integer networkNameId);

	void addMetallicList(MetallicList metallicList);

	void addProductTypeList(ProductTypeList productTypeList);

	void addGrandFatheredList(GrandfatheredList grandfatheredList);

	void addPharmacyCategoryList(PharmacyCategoryList pharmacyCategoryList);

	void addGroupTypeList(GroupTypeList groupTypeList);

	void addClaimData(ClaimData claimData);

	MetallicList getMetallic(Integer metallicId);

	ProductTypeList getProductType(Integer productTypeId);

	GrandfatheredList getGrandFather(Integer grandfatheredId);

	PharmacyCategoryList getPharmaCategory(Integer pharmacyCategoryId);

	GroupTypeList getGroupType(Integer groupTypeId);

	void deleteNetworkName(Integer networkNameId);

	void deleteMetallic(Integer metallicId);

	void deleteProductType(Integer productTypeId);

	void deleteGrandFather(Integer grandfatheredId);

	void deletePharmaCategory(Integer pharmacyCategoryId);

	void deleteGroupType(Integer groupTypeId);

	List<MarketingPlan> getMarketingPlan();

}

package com.ccsp.service.impl;

import java.security.SecureRandom;

import javax.annotation.Resource;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.ccsp.dao.AdminBenefitCostShareRepository;
import com.ccsp.dao.AdminPlanCostShareRepository;
import com.ccsp.dao.BenefitServiceRepository;
import com.ccsp.dao.ClaimCostShareRepository;
import com.ccsp.dao.ClaimDataRepository;
import com.ccsp.dao.CorporateBenefitServiceRepository;
import com.ccsp.dao.CostShareRepository;
import com.ccsp.dao.GrandfatheredBenefitServiceRepository;
import com.ccsp.dao.GrandfatheredListRepository;
import com.ccsp.dao.GroupTypeListRepository;
import com.ccsp.dao.MarketingPlanRepository;
import com.ccsp.dao.MemberAccumulatorRepository;
import com.ccsp.dao.MetallicListRepository;
import com.ccsp.dao.NetworkBenefitServiceRepository;
import com.ccsp.dao.NetworkNameListRepository;
import com.ccsp.dao.PharmacyCategoryListRepository;
import com.ccsp.dao.PlanHistoryRepository;
import com.ccsp.dao.ProcDiagCodeRepository;
import com.ccsp.dao.ProductTypeListRepository;
import com.ccsp.dao.StateBenefitServiceRepository;
import com.ccsp.dao.StateRepository;
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
import com.ccsp.service.MasterService;

@Component
public class MasterServiceImpl implements MasterService {
	
	@Resource
	private StateRepository stateRepo;
	
	@Resource
	private CostShareRepository costShareRepository;
	
	@Resource
	private StateBenefitServiceRepository stateBenefitRepository;
	
	@Resource
	private BenefitServiceRepository benefitServiceRepository;
	
	@Resource
	private CorporateBenefitServiceRepository corporateBenefitServiceRepository;
	
	@Resource
	private NetworkBenefitServiceRepository networkBenefitServiceRepository;
	
	@Resource
	private GrandfatheredBenefitServiceRepository  grandfatheredBenefitServiceRepository;
	
	@Resource
	private AdminPlanCostShareRepository  adminPlanCostShareRepository;
	
	@Resource
	private AdminBenefitCostShareRepository  adminBenefitCostShareRepository;
	
	@Resource
	private ProcDiagCodeRepository  procDiagCodeRepository;
	
	@Resource
	private ClaimCostShareRepository  claimCostShareRepository;
	
	@Resource
	private MemberAccumulatorRepository  accumulatorRepository;
	
	@Resource
	private PlanHistoryRepository  planHistoryRepository;
	
	@Resource
	private MarketingPlanRepository  marketingPlanRepository;
	
	/* edited by vishal gurung */
	@Resource
	private NetworkNameListRepository netNameRepo;

	@Resource
	private MetallicListRepository metListRepo;

	@Resource
	private ProductTypeListRepository prodTypeListRepo;

	@Resource
	private GrandfatheredListRepository grandfatheredListRepo;

	@Resource
	private PharmacyCategoryListRepository pharmacyCategoryListRepo;


	@Resource
	private GroupTypeListRepository groupTypeListRepo;


	@Resource
	private ClaimDataRepository claimDataRepo;
	


	@Override
	public void addState(StateList state) {
		
		stateRepo.save(state);
		
	}

	@Override
	public StateList getState(Integer stateId) {
		
		return stateRepo.findOne(stateId);
	}

	@Override
	public void addCostShare(CostShareList costShare) {
		
		costShareRepository.save(costShare);
	}

	@Override
	public void addStateBenifitDetails(StateBenefitServiceList stateBenefitServiceList) {
		
		stateBenefitRepository.save(stateBenefitServiceList);
	}

	@Override
	public void addBenifitService(BenefitServiceList benefitServiceList) {
		
		benefitServiceRepository.save(benefitServiceList);
	}

	@Override
	public void addCorporateBenifitService(CorporateBenefitServiceList benefitService) {
		
		corporateBenefitServiceRepository.save(benefitService);
	}

	@Override
	public void addNetworkBenifitService(NetworkBenefitServiceList benefitService) {
		
		networkBenefitServiceRepository.save(benefitService);
		
	}

	@Override
	public void addGrandFatheredBenefitService(GrandfatheredBenefitServiceList benefitService) {
		
		grandfatheredBenefitServiceRepository.save(benefitService);
		
	}

	@Override
	public void addAdminPlanCostShare(AdministrativePlanCostShareOverrides costShare) {
		adminPlanCostShareRepository.save(costShare);
		
	}

	@Override
	public void addAdminBenefitCostShare(AdminBenefitSvcCostShareOverrides costShare) {
		
		adminBenefitCostShareRepository.save(costShare);
		
	}

	@Override
	public void addProcDiagCodes(ProcCodeDiagCodeList procDiagCodes) {
		procDiagCodeRepository.save(procDiagCodes);
		
	}

	@Override
	public void addClaimCostShare(ClaimCostShareData costShareClaim) {
		
		claimCostShareRepository.save(costShareClaim);
		
	}

	@Override
	public void addMemberAccumulator(MemberAccumulatorData accumulatorData) {
		
		String id=RandomStringUtils.randomAlphanumeric(10);
		byte[] b = id.getBytes();
		accumulatorData.setNodeId(b);
		accumulatorRepository.save(accumulatorData);
		
	}

	@Override
	public void addPlanHistory(PlanObjectHistory planHistory) {
		
		planHistoryRepository.save(planHistory);
		
	}

	@Override
	public void addMarketingPlan(MarketingPlan plan) {
		String id=RandomStringUtils.randomAlphanumeric(10);
		byte[] b = id.getBytes();
		plan.setNodeId(b);
		marketingPlanRepository.save(plan);
	}

	@Override
	public void getCostShare(Integer id) {
		
		costShareRepository.findOne(id);
		
	}

	@Override
	public void getBenifitService(Integer id) {
		benefitServiceRepository.findOne(id);
		
	}

	@Override
	public void deleteBenifitService(Integer id) {
		benefitServiceRepository.delete(id);
		
	}

	@Override
	public void addCorporateBenifitService(Integer id) {

		corporateBenefitServiceRepository.findOne(id);
	}

	@Override
	public void deleteCorporateBenifitService(Integer id) {
		corporateBenefitServiceRepository.delete(id);
		
	}

	@Override
	public void deleteNetworkBenifitService(Integer id) {
		networkBenefitServiceRepository.delete(id);
	}

	@Override
	public void getNetworkBenifitService(Integer id) {
		networkBenefitServiceRepository.findOne(id);
		
	}

	@Override
	public void getGrandFatheredBenefitService(Integer id) {
		grandfatheredBenefitServiceRepository.findOne(id);
		
	}

	@Override
	public void deleteGrandFatheredBenefitService(Integer id) {
		grandfatheredBenefitServiceRepository.delete(id);
		
	}

	@Override
	public void getStateBenifitDetails(Integer id) {

		stateBenefitRepository.findOne(id);
	}

	@Override
	public void deleteStateBenifitDetails(Integer id) {
		stateBenefitRepository.delete(id);
	}

	@Override
	public void getAdminPlanCostShare(Integer id) {

		adminPlanCostShareRepository.findOne(id);
	}

	@Override
	public void deleteAdminPlanCostShare(Integer id) {
		adminPlanCostShareRepository.delete(id);
		
	}

	
	/* edited by vishal gurung*/
	@Override
	public void addNetworkName(NetworkNameList networkName) {
		netNameRepo.save(networkName);


	}

	@Override
	public NetworkNameList getNetworkName(Integer networkNameId) {
		return netNameRepo.findOne(networkNameId);
	}

	@Override
	public void addMetallicList(MetallicList metallicList) {
		metListRepo.save(metallicList);

	}

	@Override
	public void addProductTypeList(ProductTypeList productTypeList) {
		prodTypeListRepo.save(productTypeList);

	}

	@Override
	public void addGrandFatheredList(GrandfatheredList grandfatheredList) {
		grandfatheredListRepo.save(grandfatheredList);

	}

	@Override
	public void addPharmacyCategoryList(PharmacyCategoryList pharmacyCategoryList) {
		pharmacyCategoryListRepo.save(pharmacyCategoryList);

	}

	@Override
	public void addGroupTypeList(GroupTypeList groupTypeList) {
		groupTypeListRepo.save(groupTypeList);

	}

	@Override
	public void addClaimData(ClaimData claimData) {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		byte seed[] = random.generateSeed(20);
		claimData.setNodeId( seed);
		claimDataRepo.save(claimData);

	}

	@Override
	public MetallicList getMetallic(Integer metallicId) {

		return metListRepo.findOne(metallicId);
	}

	@Override
	public ProductTypeList getProductType(Integer productTypeId) {

		return prodTypeListRepo.findOne(productTypeId);
	}

	@Override
	public GrandfatheredList getGrandFather(Integer grandfatheredId) {

		return grandfatheredListRepo.findOne(grandfatheredId);
	}

	@Override
	public PharmacyCategoryList getPharmaCategory(Integer pharmacyCategoryId) {

		return pharmacyCategoryListRepo.findOne(pharmacyCategoryId);
	}

	@Override
	public GroupTypeList getGroupType(Integer groupTypeId) {

		return groupTypeListRepo.findOne(groupTypeId);
	}

	@Override
	public void deleteNetworkName(Integer networkNameId) {
		netNameRepo.delete(networkNameId);

	}

	@Override
	public void deleteMetallic(Integer metallicId) {
		metListRepo.delete(metallicId);

	}

	@Override
	public void deleteProductType(Integer productTypeId) {
		prodTypeListRepo.delete(productTypeId);

	}

	@Override
	public void deleteGrandFather(Integer grandfatheredId) {
		grandfatheredListRepo.delete(grandfatheredId);

	}

	@Override
	public void deletePharmaCategory(Integer pharmacyCategoryId) {
		pharmacyCategoryListRepo.delete(pharmacyCategoryId);

	}

	@Override
	public void deleteGroupType(Integer groupTypeId) {
		groupTypeListRepo.delete(groupTypeId);

	}
  

 

  



}

package com.ccsp.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccsp.common.HttpStatusCode;
import com.ccsp.common.Response;
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
import com.ccsp.utils.UIConstants;

import net.minidev.json.parser.ParseException;

@RestController
public class MasterController {

	
  private static Logger log = Logger.getLogger(MasterController.class);

  @Autowired
  private MasterService masterService;
	
    @RequestMapping(value = UIConstants.ADD_STATES, method = RequestMethod.POST)
    @ResponseBody
    public Response addStateDetails(@RequestBody StateList state) {
      log.info("enters into addStateDetails");
      Response response = new Response();
      masterService.addState(state);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    

    @RequestMapping(value = UIConstants.GET_STATES, method = RequestMethod.GET)
    @ResponseBody
    public Response getStateDetails(@PathVariable("stateId") Integer stateId) {
      log.info("enters into addStateDetails");
      Response response = new Response();
      response.setResult(masterService.getState(stateId));
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    
    
    @RequestMapping(value = UIConstants.COSTSHARE, method = RequestMethod.POST)
    @ResponseBody
    public Response addCostShareDetails(@RequestBody CostShareList costShare) {
      log.info("enters into addStateDetails");
      Response response = new Response();
      masterService.addCostShare(costShare);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.GETCOSTSHARE, method = RequestMethod.GET)
    @ResponseBody
    public Response getCostShareDetails(@PathVariable("id") Integer id) {
      log.info("enters into addStateDetails");
      Response response = new Response();
      masterService.getCostShare(id);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.GETCOSTSHARE, method = RequestMethod.DELETE)
    @ResponseBody
    public Response deleteCostShareDetails(@PathVariable("id") Integer id) {
      log.info("enters into addStateDetails");
      Response response = new Response();
      masterService.getCostShare(id);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    
    
    @RequestMapping(value = UIConstants.STATE_BENEFIT, method = RequestMethod.POST)
    @ResponseBody
    public Response addStateBenefitService(@RequestBody StateBenefitServiceList stateBenefitServiceList) {
      log.info("enters into addStateDetails");
      Response response = new Response();
      masterService.addStateBenifitDetails(stateBenefitServiceList);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.GET_STATE_BENEFIT, method = RequestMethod.GET)
    @ResponseBody
    public Response getStateBenefitService(@PathVariable("id") Integer id) {
      log.info("enters into addStateDetails");
      Response response = new Response();
      masterService.getStateBenifitDetails(id);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.GET_STATE_BENEFIT, method = RequestMethod.DELETE)
    @ResponseBody
    public Response deleteStateBenefitService(@PathVariable("id") Integer id) {
      log.info("enters into addStateDetails");
      Response response = new Response();
      masterService.deleteStateBenifitDetails(id);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    
    
    @RequestMapping(value = UIConstants.BENEFIT_SERVICE, method = RequestMethod.POST)
    @ResponseBody
    public Response addSBenefitService(@RequestBody BenefitServiceList benefitServiceList) {
      log.info("enters into addStateDetails");
      Response response = new Response();
      masterService.addBenifitService(benefitServiceList);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    
    @RequestMapping(value = UIConstants.GET_BENEFIT_SERVICE, method = RequestMethod.GET)
    @ResponseBody
    public Response getBenefitService(@PathVariable("id") Integer id) {
      log.info("enters into addStateDetails");
      Response response = new Response();
      masterService.getBenifitService(id);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.GET_BENEFIT_SERVICE, method = RequestMethod.DELETE)
    @ResponseBody
    public Response deleteBenefitService(@PathVariable("id") Integer id) {
      log.info("enters into addStateDetails");
      Response response = new Response();
      masterService.deleteBenifitService(id);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.CORPORATE_BENEFIT_SERVICE, method = RequestMethod.POST)
    @ResponseBody
    public Response addCorporateBenefitService(@RequestBody CorporateBenefitServiceList benefitService) {
      log.info("enters into addStateDetails");
      Response response = new Response();
      masterService.addCorporateBenifitService(benefitService);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.GET_CORPORATE_BENEFIT_SERVICE, method = RequestMethod.GET)
    @ResponseBody
    public Response getCorporateBenefitService(@PathVariable("id") Integer id) {
      log.info("enters into addStateDetails");
      Response response = new Response();
      masterService.addCorporateBenifitService(id);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.GET_CORPORATE_BENEFIT_SERVICE, method = RequestMethod.DELETE)
    @ResponseBody
    public Response deleteCorporateBenefitService(@PathVariable("id") Integer id) {
      log.info("enters into addStateDetails");
      Response response = new Response();
      masterService.deleteCorporateBenifitService(id);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.NETWORK_BENEFIT_SERVICE, method = RequestMethod.POST)
    @ResponseBody
    public Response addNetworkBenefitService(@RequestBody NetworkBenefitServiceList benefitService) {
      log.info("enters into addNetworkBenefitService");
      Response response = new Response();
      masterService.addNetworkBenifitService(benefitService);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.GET_NETWORK_BENEFIT_SERVICE, method = RequestMethod.GET)
    @ResponseBody
    public Response getNetworkBenefitService(@PathVariable("id") Integer id) {
      log.info("enters into addNetworkBenefitService");
      Response response = new Response();
      masterService.getNetworkBenifitService(id);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.NETWORK_BENEFIT_SERVICE, method = RequestMethod.GET)
    @ResponseBody
    public Response deleteNetworkBenefitService(@PathVariable("id") Integer id) {
      log.info("enters into addNetworkBenefitService");
      Response response = new Response();
      masterService.deleteNetworkBenifitService(id);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.GRANDFATHERED_BENEFIT_SERVICE, method = RequestMethod.POST)
    @ResponseBody
    public Response addGrandFatheredBenefitService(@RequestBody GrandfatheredBenefitServiceList benefitService) {
      log.info("enters into addNetworkBenefitService");
      Response response = new Response();
      masterService.addGrandFatheredBenefitService(benefitService);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.GET_GRANDFATHERED_BENEFIT_SERVICE, method = RequestMethod.GET)
    @ResponseBody
    public Response getGrandFatheredBenefitService(@PathVariable("id") Integer id) {
      log.info("enters into addNetworkBenefitService");
      Response response = new Response();
      masterService.getGrandFatheredBenefitService(id);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.GET_GRANDFATHERED_BENEFIT_SERVICE, method = RequestMethod.DELETE)
    @ResponseBody
    public Response deleteGrandFatheredBenefitService(@PathVariable("id") Integer id) {
      log.info("enters into addNetworkBenefitService");
      Response response = new Response();
      masterService.deleteGrandFatheredBenefitService(id);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    
   
    @RequestMapping(value = UIConstants.ADMIN_PLAN_COST_SHARE, method = RequestMethod.POST)
    @ResponseBody
    public Response addAdminPlanCostShare(@RequestBody AdministrativePlanCostShareOverrides costShare) {
      log.info("enters into addAdminPlanCostShare");
      Response response = new Response();
      masterService.addAdminPlanCostShare(costShare);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.GET_ADMIN_PLAN_COST_SHARE, method = RequestMethod.GET)
    @ResponseBody
    public Response getAdminPlanCostShare(@PathVariable("id") Integer id) {
      log.info("enters into addAdminPlanCostShare");
      Response response = new Response();
      masterService.getAdminPlanCostShare(id);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.GET_ADMIN_PLAN_COST_SHARE, method = RequestMethod.DELETE)
    @ResponseBody
    public Response deleteAdminPlanCostShare(@PathVariable("id") Integer id) {
      log.info("enters into addAdminPlanCostShare");
      Response response = new Response();
      masterService.deleteAdminPlanCostShare(id);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    
    @RequestMapping(value = UIConstants.ADMIN_BENEFIT_COST_SHARE, method = RequestMethod.POST)
    @ResponseBody
    public Response addAdminBenefitCostShare(@RequestBody AdminBenefitSvcCostShareOverrides costShare) {
      log.info("enters into addAdminBenefitCostShare");
      Response response = new Response();
      masterService.addAdminBenefitCostShare(costShare);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.ADMIN_BENEFIT_COST_SHARE, method = RequestMethod.GET)
    @ResponseBody
    public Response getAdminBenefitCostShare(@RequestBody AdminBenefitSvcCostShareOverrides costShare) {
      log.info("enters into addAdminBenefitCostShare");
      Response response = new Response();
      masterService.addAdminBenefitCostShare(costShare);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    
    
    @RequestMapping(value = UIConstants.PROC_DIAG_CODE, method = RequestMethod.POST)
    @ResponseBody
    public Response addProcDiagCodes(@RequestBody ProcCodeDiagCodeList procDiagCodes) {
      log.info("enters into addAdminBenefitCostShare");
      Response response = new Response();
      masterService.addProcDiagCodes(procDiagCodes);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    
    @RequestMapping(value = UIConstants.CLAIM_COST_SHARE, method = RequestMethod.POST)
    @ResponseBody
    public Response addClaimCostShare(@RequestBody ClaimCostShareData costShareClaim) {
      log.info("enters into addClaimCostShare");
      Response response = new Response();
          
      masterService.addClaimCostShare(costShareClaim);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.MEMBER_ACCUMULATOR, method = RequestMethod.POST)
    @ResponseBody
    public Response addMemberAccumulator(@RequestBody MemberAccumulatorData accumulatorData) {
      log.info("enters into addClaimCostShare");
      Response response = new Response();
          
      masterService.addMemberAccumulator(accumulatorData);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    
    @RequestMapping(value = UIConstants.PLAN_HISTORY, method = RequestMethod.POST)
    @ResponseBody
    public Response addPlanHistory(@RequestBody PlanObjectHistory planHistory) {
      log.info("enters into addClaimCostShare");
      Response response = new Response();
          
      masterService.addPlanHistory(planHistory);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    
    @RequestMapping(value = UIConstants.MARKETING_PLAN, method = RequestMethod.POST)
    @ResponseBody
    public Response addMarketingPlan(@RequestBody MarketingPlan plan) {
      log.info("enters into addClaimCostShare");
      Response response = new Response();
          
      masterService.addMarketingPlan(plan);
      response.setStatus(HttpStatusCode.Success);
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.MARKETING_PLAN, method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<com.ccsp.model.MarketingPlan> getMarketingPlan() throws ParseException {
      log.info("enters into getMarketingPlan");
      List<com.ccsp.model.MarketingPlan> marketResponseList = new ArrayList<com.ccsp.model.MarketingPlan>();
      List<MarketingPlan> daoResponse =  masterService.getMarketingPlan();
      for(MarketingPlan plan : daoResponse){
    	  com.ccsp.model.MarketingPlan marketResponse = new com.ccsp.model.MarketingPlan();
    	  marketResponse.setNodeId(String.valueOf(plan.getMktPlanId()));
    	  marketResponse.setNodeLevel(plan.getNodeLevel());
    	  marketResponse.setAdminPlanId(plan.getAdminPlanId());
    	  marketResponse.setMktPlanId(plan.getMktPlanId());
    	  marketResponse.setMktPlanName(plan.getMktPlanName());
    	  marketResponse.setMktPlanEffectiveDate(plan.getMktPlanEffectiveDate());
    	  marketResponse.setMktPlanExpirationDate(plan.getMktPlanExpirationDate());
    	  marketResponse.setMktPlanType(plan.getMktPlanType());
    	  marketResponse.setMktPlanCoverage(plan.getMktPlanCoverage());
    	  marketResponse.setMktPlanNetworkName(plan.getMktPlanNetworkName());
    	  marketResponse.setMktPlanFormulary(plan.getMktPlanFormulary());
    	  marketResponse.setMktPlanCurrentOrProposed(plan.getMktPlanCurrentOrProposed());
    	  marketResponse.setMktPlanStateName(plan.getMktPlanStateName());
    	  marketResponse.setMktPlanHsaeligible(plan.getMktPlanHsaeligible());
    	  marketResponseList.add(marketResponse);
      }
      return marketResponseList;
    }
    
    
    /* edited by vishal gurung*/
	/** NetworkNameList*/

	@RequestMapping(value = UIConstants.ADD_NETWORK_NAME, method = RequestMethod.POST)
	@ResponseBody
	public Response addNetworkName(@RequestBody NetworkNameList NetworkName) {
		log.info("enters into addNetworkName");
		Response response = new Response();
		masterService.addNetworkName(NetworkName);
		response.setStatus(HttpStatusCode.Success);
		return response;

	}

	@RequestMapping(value = UIConstants.GET_NETWORK_NAME, method = RequestMethod.GET)
	@ResponseBody
	public Response getNetworkName(@PathVariable("networkNameId") Integer networkNameId) {
		log.info("enters into getNetworkName");
		Response response = new Response();
		response.setResult(masterService.getNetworkName(networkNameId));
		response.setStatus(HttpStatusCode.Success);
		return response;

	}


	@RequestMapping(value = UIConstants.GET_NETWORK_NAME, method = RequestMethod.DELETE)
	@ResponseBody
	public Response deleteNetworkName(@PathVariable("networkNameId") Integer networkNameId) {
		log.info("enters into getNetworkName");
		Response response = new Response();
		masterService.deleteNetworkName(networkNameId);
		response.setStatus(HttpStatusCode.Success);
		return response;

	}

	@RequestMapping(value = UIConstants.ADD_METALLIC_LIST, method = RequestMethod.POST)
	@ResponseBody
	public Response addMetallicList(@RequestBody MetallicList metallicList) {
		log.info("enters into addMetallicList");
		Response response = new Response();
		masterService.addMetallicList(metallicList);
		response.setStatus(HttpStatusCode.Success);
		return response;

	}

	@RequestMapping(value = UIConstants.GET_METALLIC, method = RequestMethod.GET)
	@ResponseBody
	public Response getMetallic(@PathVariable("metallicId") Integer metallicId) {
		log.info("enters into getMetallic");
		Response response = new Response();
		response.setResult(masterService.getMetallic(metallicId));
		response.setStatus(HttpStatusCode.Success);
		return response;

	}

	@RequestMapping(value = UIConstants.GET_METALLIC, method = RequestMethod.DELETE)
	@ResponseBody
	public Response deleteMetallic(@PathVariable("metallicId") Integer metallicId) {
		log.info("enters into deleteMetallic");
		Response response = new Response();
		masterService.deleteMetallic(metallicId);
		response.setStatus(HttpStatusCode.Success);
		return response;

	}

	@RequestMapping(value = UIConstants.ADD_PRODUCT_TYPE_LIST, method = RequestMethod.POST)
	@ResponseBody
	public Response addProductTypeList(@RequestBody ProductTypeList productTypeList) {
		log.info("enters into addProductTypeList");
		Response response = new Response();
		masterService.addProductTypeList(productTypeList);
		response.setStatus(HttpStatusCode.Success);
		return response;

	}
	@RequestMapping(value = UIConstants.GET_PRODUCT_TYPE, method = RequestMethod.GET)
	@ResponseBody
	public Response getProductType(@PathVariable("productTypeId") Integer productTypeId) {
		log.info("enters into getProductType");
		Response response = new Response();
		response.setResult(masterService.getProductType(productTypeId));
		response.setStatus(HttpStatusCode.Success);
		return response;

	}

	@RequestMapping(value = UIConstants.GET_PRODUCT_TYPE, method = RequestMethod.DELETE)
	@ResponseBody
	public Response deleteProductType(@PathVariable("productTypeId") Integer productTypeId) {
		log.info("enters into deleteProductType");
		Response response = new Response();
		masterService.deleteProductType(productTypeId);
		response.setStatus(HttpStatusCode.Success);
		return response;

	}


	@RequestMapping(value = UIConstants.ADD_GRAND_FATHERED_LIST, method = RequestMethod.POST)
	@ResponseBody
	public Response addGrandFatheredList(@RequestBody GrandfatheredList grandfatheredList) {
		log.info("enters into addGrandFatheredList");
		Response response = new Response();
		masterService.addGrandFatheredList(grandfatheredList);
		response.setStatus(HttpStatusCode.Success);
		return response;

	}

	@RequestMapping(value = UIConstants.GET_GRAND_FATHER, method = RequestMethod.GET)
	@ResponseBody
	public Response getGrandFather(@PathVariable("grandfatheredId") Integer grandfatheredId) {
		log.info("enters into getGrandFather");
		Response response = new Response();
		response.setResult(masterService.getGrandFather(grandfatheredId));
		response.setStatus(HttpStatusCode.Success);
		return response;

	}

	@RequestMapping(value = UIConstants.GET_GRAND_FATHER, method = RequestMethod.DELETE)
	@ResponseBody
	public Response deleteGrandFather(@PathVariable("grandfatheredId") Integer grandfatheredId) {
		log.info("enters into deleteGrandFather");
		Response response = new Response();
		masterService.deleteGrandFather(grandfatheredId);
		response.setStatus(HttpStatusCode.Success);
		return response;

	}


	@RequestMapping(value = UIConstants.ADD_PHARMACY_CATEGORY_LIST, method = RequestMethod.POST)
	@ResponseBody
	public Response addPharmacyCategoryList(@RequestBody PharmacyCategoryList pharmacyCategoryList) {
		log.info("enters into addPharmacyCategoryList");
		Response response = new Response();
		masterService.addPharmacyCategoryList(pharmacyCategoryList);
		response.setStatus(HttpStatusCode.Success);
		return response;

	}

	@RequestMapping(value = UIConstants.GET_PHARMACY_CATEGORY, method = RequestMethod.GET)
	@ResponseBody
	public Response getPharmaCategory(@PathVariable("pharmacyCategoryId") Integer pharmacyCategoryId) {
		log.info("enters into getPharmaCategory");
		Response response = new Response();
		response.setResult(masterService.getPharmaCategory(pharmacyCategoryId));
		response.setStatus(HttpStatusCode.Success);
		return response;

	}

	@RequestMapping(value = UIConstants.GET_PHARMACY_CATEGORY, method = RequestMethod.DELETE)
	@ResponseBody
	public Response deletePharmaCategory(@PathVariable("pharmacyCategoryId") Integer pharmacyCategoryId) {
		log.info("enters into deletePharmaCategory");
		Response response = new Response();
		masterService.deletePharmaCategory(pharmacyCategoryId);
		response.setStatus(HttpStatusCode.Success);
		return response;

	}


	@RequestMapping(value = UIConstants.ADD_GROUP_TYPE_LIST, method = RequestMethod.POST)
	@ResponseBody
	public Response addGroupTypeList(@RequestBody GroupTypeList groupTypeList) {
		log.info("enters into addGroupTypeList");
		Response response = new Response();
		masterService.addGroupTypeList(groupTypeList);
		response.setStatus(HttpStatusCode.Success);
		return response;

	}

	@RequestMapping(value = UIConstants.GET_GROUP_TYPE, method = RequestMethod.GET)
	@ResponseBody
	public Response getGroupType(@PathVariable("groupTypeId") Integer groupTypeId) {
		log.info("enters into getGroupType");
		Response response = new Response();
		response.setResult(masterService.getGroupType(groupTypeId));
		response.setStatus(HttpStatusCode.Success);
		return response;

	}

	@RequestMapping(value = UIConstants.GET_GROUP_TYPE, method = RequestMethod.DELETE)
	@ResponseBody
	public Response deleteGroupType(@PathVariable("groupTypeId") Integer groupTypeId) {
		log.info("enters into deleteGroupType");
		Response response = new Response();
		masterService.deleteGroupType(groupTypeId);
		response.setStatus(HttpStatusCode.Success);
		return response;

	}

	@RequestMapping(value = UIConstants.ADD_CLAIM_DATA, method = RequestMethod.POST)
	@ResponseBody
	public Response addClaimData(@RequestBody ClaimData claimData) {
		log.info("enters into addClaimData");
		Response response = new Response();
		masterService.addClaimData(claimData);
		response.setStatus(HttpStatusCode.Success);
		return response;

	} 
}

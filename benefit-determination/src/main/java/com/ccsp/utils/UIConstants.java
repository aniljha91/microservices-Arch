package com.ccsp.utils;

public class UIConstants {


	private UIConstants()
	{

	}

	public static final String MEMBER_LIST = "/members";
	public static final String PLAN_LIST = "/plans";
	public static final String DIAGNOSTIC_CODES ="/diagnostics";
	public static final String PROCEDURE_CODES = "/procedures";
	public static final String GET_CLAIM_RULES = "/claim/rules";
	public static final String ADD_STATES = "/states";
	public static final String GET_STATES = "/state/{stateId}";
	public static final String COSTSHARE = "/costShare";
	public static final String GETCOSTSHARE = "/costShare/{id}";
	public static final String STATE_BENEFIT = "/stateBenefitService";
	public static final String GET_STATE_BENEFIT = "/stateBenefitService/{id}";
	public static final String BENEFIT_SERVICE = "/benefitService";
	public static final String GET_BENEFIT_SERVICE = "/benefitService/{id}";
	public static final String CORPORATE_BENEFIT_SERVICE = "/corporateBenefitService";
	public static final String GET_CORPORATE_BENEFIT_SERVICE = "/corporateBenefitService/{id}";
	public static final String NETWORK_BENEFIT_SERVICE = "/networkBenefitService";
	public static final String GET_NETWORK_BENEFIT_SERVICE = "/networkBenefitService/{id}";

	public static final String GRANDFATHERED_BENEFIT_SERVICE = "/grandFatheredBenefitService";
	public static final String GET_GRANDFATHERED_BENEFIT_SERVICE = "/grandFatheredBenefitService/{id}";

	public static final String ADMIN_PLAN_COST_SHARE = "/adminPlanCostShare";
	public static final String GET_ADMIN_PLAN_COST_SHARE = "/adminPlanCostShare/{id}";

	public static final String ADMIN_BENEFIT_COST_SHARE = "/adminBenefitCostShare";
	public static final String GET_BENEFIT_COST_SHARE = "/adminBenefitCostShare/{id}";

	public static final String PROC_DIAG_CODE = "/procDiag";
	public static final String GET_PROC_DIAG_CODE = "/procDiag/{id}";

	public static final String CLAIM_COST_SHARE = "/claimCostShare";
	public static final String GET_CLAIM_COST_SHARE = "/claimCostShare/{id}";

	public static final String MEMBER_ACCUMULATOR = "/memberAccumulator";
	public static final String GET_MEMBER_ACCUMULATOR = "/memberAccumulator/{id}";

	public static final String PLAN_HISTORY = "/planHistory";
	public static final String MARKETING_PLAN = "/marketingPlan";

	/* edited by vishal gurung*/
	public static final String ADD_NETWORK_NAME = "/addNetworkName";
	public static final String GET_NETWORK_NAME = "/networkNames/{networkNameId}";


	public static final String ADD_METALLIC_LIST = "/addMetallicList";
	public static final String GET_METALLIC = "/metallicList/{metallicId}";


	public static final String ADD_PRODUCT_TYPE_LIST = "/addProductTypeList";
	public static final String GET_PRODUCT_TYPE = "/productTypeList/{productTypeId}";


	public static final String ADD_GRAND_FATHERED_LIST= "/addGrandFatheredList";
	public static final String GET_GRAND_FATHER = "/grandFatheredList/{grandfatheredId}";


	public static final String ADD_PHARMACY_CATEGORY_LIST = "/addPharmacyCategoryList";
	public static final String GET_PHARMACY_CATEGORY= "/pharmacyCategoryList/{pharmacyCategoryId}";


	public static final String ADD_GROUP_TYPE_LIST = "/addGroupTypeList";
	public static final String GET_GROUP_TYPE= "/groupTypeList/{groupTypeId}";


	public static final String ADD_CLAIM_DATA = "/addClaimData";
	public static final String GET_CLAIM_DATA = "/claimData/{nodeId}";


}

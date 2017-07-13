package com.ccsp.utils;

public enum QueryConstant {

	USERQUERY("select firstname, lastname, username, password, role, role_display_name FROM users"),
	RULEQUERY("select value FROM service_rules"),
	UPDATERULEQUERY("update service_rules set value = "),
	UPDATETOTALDEDUCTABLEAMOUNT("update member_plan set total_deductable_amount = ");;
	
	private String query;

	QueryConstant(String query) {
        this.query = query;
    }

    public String query() {
        return query;
    }
	
}

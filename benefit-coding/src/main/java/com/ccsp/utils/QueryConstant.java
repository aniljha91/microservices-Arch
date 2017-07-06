package com.ccsp.utils;

public enum QueryConstant {

	USERQUERY("select id, firstname, lastname, [role], username, [password], age, salary FROM users"),
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

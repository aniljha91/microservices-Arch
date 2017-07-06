package com.ccsp.dao.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ccsp.dao.RuleDAO;
import com.ccsp.entity.PlanServiceEntity;

@Repository
public class RuleDAOImpl implements RuleDAO{
	
	@PersistenceContext
    EntityManager entityManager;
	
	@Override
    public PlanServiceEntity getServiceRule(String planId, String serviceName) {
        Query query = entityManager.createNativeQuery("SELECT * FROM plan_rule_service WHERE plan_id = ? and service_name = ?", PlanServiceEntity.class);
        query.setParameter(1, planId);
        query.setParameter(2, serviceName);
        return (PlanServiceEntity)query.getSingleResult();
    }
	
	@Override
    public Double getTotalDeductableAmount(int memberId, String planId) {
        Query query = entityManager.createNativeQuery("SELECT total_deductable_amount FROM member_plan WHERE member_id = ? and plan_id=? ");
        query.setParameter(1, memberId);
        query.setParameter(2, planId);
        BigDecimal result = (BigDecimal)query.getSingleResult();
        return result.doubleValue();
    }
	

}

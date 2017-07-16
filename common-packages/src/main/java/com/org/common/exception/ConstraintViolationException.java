package com.org.common.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.org.common.model.dto.IDto;


/**
 * @author bsakariboina
 *
 */
public class ConstraintViolationException extends BaseException {

	private static final long serialVersionUID = 1L;
	private Set<ConstraintViolation<IDto>> constraintViolations;
    public ConstraintViolationException(Set<ConstraintViolation<IDto>> violations) {
        super("Constraint Violations found");
        this.constraintViolations = violations;
    }
	public Set<ConstraintViolation<IDto>> getConstraintViolations() {
		return constraintViolations;
	}
    
}

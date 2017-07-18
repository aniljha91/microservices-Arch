package com.org.gateway.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TokenDetails", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class TokenDetails implements Serializable {

	private static final long serialVersionUID = -1805823833520884148L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	private String username;
	private String password;
	private String token;
	private String role;
	private Date tokenAssignedDate;
	private Date tokenExpirationdDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getTokenAssignedDate() {
		return tokenAssignedDate;
	}

	public void setTokenAssignedDate(Date tokenAssignedDate) {
		this.tokenAssignedDate = tokenAssignedDate;
	}

	public Date getTokenExpirationdDate() {
		return tokenExpirationdDate;
	}

	public void setTokenExpirationdDate(Date tokenExpirationdDate) {
		this.tokenExpirationdDate = tokenExpirationdDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

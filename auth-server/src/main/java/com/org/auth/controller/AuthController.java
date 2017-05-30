package com.org.auth.controller;

import java.security.InvalidKeyException;
import java.security.SignatureException;
import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import com.org.auth.domain.TokenDetails;
import com.org.auth.domain.User;

import net.oauth.jsontoken.JsonToken;
import net.oauth.jsontoken.JsonTokenParser;
import net.oauth.jsontoken.crypto.HmacSHA256Signer;
import net.oauth.jsontoken.crypto.HmacSHA256Verifier;
import net.oauth.jsontoken.crypto.SignatureAlgorithm;
import net.oauth.jsontoken.crypto.Verifier;
import net.oauth.jsontoken.discovery.VerifierProvider;
import net.oauth.jsontoken.discovery.VerifierProviders;

@RestController
public class AuthController {

	private static final String AUDIENCE = "Browser";

	private static final String ISSUER = "AUTHENTICATOR";

	private static final String SIGNING_KEY = "testing$$%%JWT<>@Authentication";

	@RequestMapping(value = "/generateToken", method = RequestMethod.POST, consumes="application/json")
	public static @ResponseBody String createJsonWebToken(@RequestBody User user) {
		// Current time and signing algorithm
		Calendar cal = Calendar.getInstance();
		HmacSHA256Signer signer;
		try {
			signer = new HmacSHA256Signer(ISSUER, null, SIGNING_KEY.getBytes());
		} catch (InvalidKeyException e) {
			throw new RuntimeException(e);
		}

		// Configure JSON token
		JsonToken token = new net.oauth.jsontoken.JsonToken(signer);
		token.setAudience(AUDIENCE);
		token.setIssuedAt(new org.joda.time.Instant(cal.getTimeInMillis()));
		token.setExpiration(new org.joda.time.Instant(cal.getTimeInMillis() + 1000L * 60L * 60L * 24L));

		// Configure request object, which provides information of the item
		JsonObject request = new JsonObject();
		request.addProperty("userId", user.getUsername());
		JsonObject payload = token.getPayloadAsJsonObject();
		payload.add("info", request);
		try {
			return token.serializeAndSign();
		} catch (SignatureException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Verifies a json web token's validity and extracts the user id and other
	 * information from it.
	 * 
	 * @param token
	 * @return
	 * @throws SignatureException
	 * @throws InvalidKeyException
	 */
	@RequestMapping(value = "/verifyToken", method = RequestMethod.POST, produces="application/json", consumes="text/plain")
	public static @ResponseBody TokenDetails verifyToken(@RequestBody String token) {
		try {
			final Verifier hmacVerifier = new HmacSHA256Verifier(SIGNING_KEY.getBytes());
			VerifierProvider hmacLocator = new VerifierProvider() {
				@Override
				public List<Verifier> findVerifier(String id, String key) {
					return Lists.newArrayList(hmacVerifier);
				}
			};
			VerifierProviders locators = new VerifierProviders();
			locators.setVerifierProvider(SignatureAlgorithm.HS256, hmacLocator);
			net.oauth.jsontoken.Checker checker = new net.oauth.jsontoken.Checker() {
				@Override
				public void check(JsonObject payload) throws SignatureException {
					// don't throw - allow anything
				}
			};
			// Ignore Audience does not mean that the Signature is ignored
			JsonTokenParser parser = new JsonTokenParser(locators, checker);
			JsonToken jt;
			try {
				jt = parser.verifyAndDeserialize(token);
			} catch (SignatureException e) {
				throw new RuntimeException(e);
			}
			JsonObject payload = jt.getPayloadAsJsonObject();
			TokenDetails t = new TokenDetails();
			String issuer = payload.getAsJsonPrimitive("iss").getAsString();
			String userIdString = payload.getAsJsonObject("info").getAsJsonPrimitive("userId").getAsString();
			if (issuer.equals(ISSUER) && !userIdString.equals("")) {
				t.setUserId(userIdString);
				t.setIssued(new DateTime(payload.getAsJsonPrimitive("iat").getAsLong()));
				t.setExpires(new DateTime(payload.getAsJsonPrimitive("exp").getAsLong()));
				return t;
			} else {
				return null;
			}
		} catch (InvalidKeyException e1) {
			throw new RuntimeException(e1);
		}
	}
}

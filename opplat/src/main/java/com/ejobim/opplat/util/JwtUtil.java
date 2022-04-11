package com.ejobim.opplat.util;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.vo.TokenSubject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//import com.beust.jcommander.internal.Maps;

@Component
public class JwtUtil {

	//Value("${spring.profiles.active}")
	private  static String profiles ="dev";

	public static final String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";

	//@Value("${jwt.id}")
	private String JWT_ID="jwt";
	//@Value("${jwt.ttl}")
	private long JWT_TTL =31536000L;
	//@Value("${jwt.refreshttl}")
	private long JWT_REFRESH_TTL=31536000L;
	/**
	 * 由字符串生成加密key
	 * 
	 * @return
	 */
	public SecretKey generalKey() {
		String stringKey = profiles + JWT_SECRET;
		byte[] encodedKey = Base64.decodeBase64(stringKey);
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
		return key;
	}

	/**
	 * 创建token和refreshToken
	 * @param subject
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> createTokenAndRereshToken(String subject) throws Exception {
		String token = createJWT(JWT_ID, subject, JWT_TTL * 1000);
		String refreshToken = createJWT(JWT_ID, subject, JWT_REFRESH_TTL * 1000);
		Map rs = new HashMap();
		rs.put("token",token);
		rs.put("refreshToken",refreshToken);
		return rs;
	}

	/**
	 * 创建token和refreshToken
	 * @param subject
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> createTokenAndRereshToken(TokenSubject subject) throws Exception {
		String subjectString = JwtUtil.generalSubject(subject);
			//31536000
		String token = createJWT(JWT_ID, subjectString, JWT_TTL * 1000);
		String refreshToken = createJWT(JWT_ID, subjectString, JWT_REFRESH_TTL * 1000);
		Map rs = new HashMap();
		rs.put("token",token);
		rs.put("refreshToken",refreshToken);
		return rs;
	}

	/**
	 * 创建jwt
	 * 
	 * @param id
	 * @param subject
	 * @param ttlMillis
	 * @return
	 * @throws Exception
	 */
	public String createJWT(String id, String subject, long ttlMillis) throws Exception {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		SecretKey key = generalKey();
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).signWith(signatureAlgorithm,
				key);
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		return builder.compact();
	}

	/**
	 * 解密jwt
	 * 
	 * @param jwt
	 * @return
	 * @throws Exception
	 */
	public Claims parseJWT(String jwt) throws Exception {
		SecretKey key = generalKey();
		Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
		return claims;
	}

	/**
	 * 生成subject信息
	 * 
	 * @param ts
	 * @return
	 */
	public static String generalSubject(TokenSubject ts) {
		JSONObject jo = new JSONObject();
		jo.put("userid", ts.getUserid());
		jo.put("accountId", ts.getAccountId());
		jo.put("adminType", ts.getAdminType());
		jo.put("memberType", ts.getMemberType());
		jo.put("sessionid", ts.getSessionid());
		jo.put("userAgent", ts.getUserAgent());
		jo.put("imAccid", ts.getImAccid());
		jo.put("imToken", ts.getImToken());
		return jo.toJSONString();
	}

}

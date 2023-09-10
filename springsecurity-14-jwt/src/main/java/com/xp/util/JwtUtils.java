package com.xp.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/9/10 10:54
 * @since 1.0
 **/
public class JwtUtils {
    private static final String secret = "secret888";

    public static String createJwt(Integer userId, String username, List<String> authList) {
        Map<String, Object> headerClaims = new HashMap<>();
        headerClaims.put("alg", "HS256");
        headerClaims.put("type", "JWT");
        Date issDate = new Date();
        Date expireDate = new Date(issDate.getTime() + 1000 * 30);
        return JWT.create().withHeader(headerClaims)
                .withIssuer("thomas") //设置签发人
                .withIssuedAt(issDate) //设置签发时间
                .withExpiresAt(expireDate)//设置过期时间
                .withClaim("userID", userId)
                .withClaim("username", username)
                .withClaim("auth", authList) //自定义声明
                .sign(Algorithm.HMAC256(secret));//使用HS256进行签名，使用secret作为密钥
    }

    public static boolean verifyToken(String jwtToken) {
        //创建校验器
        try {
            JWTVerifier jwt = JWT.require(Algorithm.HMAC256(secret)).build();
            DecodedJWT decodedJWT = jwt.verify(jwtToken);
            System.out.println("token验证正确");
            Integer userID = decodedJWT.getClaim("userID").asInt();
            String username = decodedJWT.getClaim("username").asString();
            List<String> auth = decodedJWT.getClaim("auth").asList(String.class);
            return true;
        } catch (Exception e) {
            System.out.println("token验证不正确");
            return false;
        }
    }
}

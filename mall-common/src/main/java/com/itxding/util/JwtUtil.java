package com.itxding.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT 工具类
 */
public class JwtUtil {

    /**
     * 自定义密钥（生产环境请放到配置文件里，不要写死）
     */
    private static final String SECRET_KEY = "mall-seckill-secret-key-2026";

    /**
     * Token 过期时间：7天（单位：毫秒）
     */
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000L;

    /**
     * 生成 Token
     * @param userId 用户ID
     * @param username 用户名
     * @return Token 字符串
     */
    public static String generateToken(Long userId, String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("username", username);
        return Jwts.builder()
                .setClaims(claims) //添加自定义数据
                .setIssuedAt(new Date()) //签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME)) //过期时间
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // 前面算法和密钥
                .compact();
    }

    /**
     * 解析 Token，获取 Claims（包含用户信息）
     * @param token Token 字符串
     * @return Claims 对象
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)  //设置解析密钥
                .parseClaimsJws(token)  //解析令牌
                .getBody();
    }

    /**
     * 从 Token 中获取用户ID
     */
    public static Long getUserId(String token) {
        Claims claims = parseToken(token);
        return Long.valueOf(claims.get("userId").toString());
    }

    /**
     * 从 Token 中获取用户名
     */
    public static String getUsername(String token) {
        Claims claims = parseToken(token);
        return claims.get("username").toString();
    }

    /**
     * 校验 Token 是否有效
     * @param token Token 字符串
     * @return true=有效，false=无效
     */
    public static boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
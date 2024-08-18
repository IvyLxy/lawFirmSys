package com.ychs.lawfirmsys.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Jwt(JSON Web token)工具类 用户认证
 * jwt json字符串 jwttoken 带有签名信息 接收后可校验是否被篡改
 *      header标头 payload有效载荷 signature签名（包含一个密钥）
 * UUID  不安全，别人易仿照
 *
 * @author ruoyi
 */
public class JwtUtils
{
    // 密钥
    public static String secret = "abcdefghijklmnopqrstuvwxyz";

    /**
     * 从数据声明生成令牌 不好伪造
     *
     * @param claims 数据声明 有效载荷
     * @return 令牌
     */
    public static String createToken(Map<String, Object> claims){
        String token = Jwts.builder().
                setClaims(claims).
                signWith(SignatureAlgorithm.HS512, secret).compact();
        return token;
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    public static Claims parseToken(String token)
    {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public static void main(String[] args) {
        Map claims = new HashMap();
        claims.put("name","admin");
        claims.put("age",123);

        String token = JwtUtils.createToken(claims);
        System.out.println(token);
        Claims claims1 = JwtUtils.parseToken(token);
        System.out.println(claims1.get("name"));
        System.out.println(claims1.get("age"));
    }
}

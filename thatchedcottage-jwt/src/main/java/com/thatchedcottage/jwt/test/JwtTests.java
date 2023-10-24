package com.thatchedcottage.jwt.test;

import io.jsonwebtoken.*;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

/**
 * @program: thatchedcottage
 * @description: JWT测试类
 * @author:
 * @create: 2023-10-07 11:29
 **/
public class JwtTests {
    private long time = 1000 * 60 * 60 * 1;
    private static String sign = "admin";

    /*生成  JWT*/
    @Test
    public void createJwt() {

        /*1: 创建 JwtBuilder 对象*/
        JwtBuilder jwtBuilder = Jwts.builder();
        /*2: 生成JwtToken -> abc.def.xyz*/
        String jwtToken = jwtBuilder
                /*Header 头部*/
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                /*Payload：载荷 负载*/
                .claim("username","tom")
                .claim("role","admin")
                .setSubject("admin-test")
                /*设置 ID 字段*/
                .setId(UUID.randomUUID().toString())
                /*Token 过期时间*/
                .setExpiration(new Date(System.currentTimeMillis() + time))
                /*设置签名 Signatrue*/
                /* 设置加密算法 及 签名*/
                .signWith(SignatureAlgorithm.HS256,sign)
                /* 使用 “.” 连接成一个完整的字符串*/
                .compact();

        System.err.println(jwtToken);
    /*
      eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRvbSIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJqdGkiOiI0YzgzMjk0NC01ZWJkLTQzZmQtYTUzMi03ZjNhM2E4ZDNjMTMiLCJleHAiOjE2OTY2NjE3MjF9.RBmP6CAF91BuujQGoIHFcOzHvl9O8HzNoSCzj6hx2GE
*/

    }

    /*验证 JWT*/
    @Test
    public void checkJwt() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRvbSIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJqdGkiOiI3ZWRjNDE3NS01ZjdkLTRiZjItYWJkMC1lZmZkZmJiZjdlNjQiLCJleHAiOjE2OTY2NTQwOTR9.4YH2U3lVcQ3pMOjWEAaQRV7hRxbG6qzA9K75kWe9I3M";
        /* parser 解析器*/
        /* isSigned 是否签名*/
        boolean signed = Jwts.parser().isSigned(token);
        System.err.println(signed);
    }

    /*解析 JWT*/
    @Test
    public void parseJwt() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRvbSIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJqdGkiOiI0YzgzMjk0NC01ZWJkLTQzZmQtYTUzMi03ZjNhM2E4ZDNjMTMiLCJleHAiOjE2OTY2NjE3MjF9.RBmP6CAF91BuujQGoIHFcOzHvl9O8HzNoSCzj6hx2GE";
        /*获取 Jwt 的解析对象*/
        JwtParser jwtParser = Jwts.parser();
        /*将 Jwt 转化为一个 key-value 通过key来获取对应的value  类似Map集合*/
        Jws<Claims> claimsJws = jwtParser.setSigningKey(sign).parseClaimsJws(token);
        /*获取 Jws 对象中的数据 : get(key) 表示根据 key 来获取value*/
        Claims claims = claimsJws.getBody();/*存储的是用户保存的数据*/
        System.err.println(claims.get("username"));
        System.err.println(claims.get("role"));
        System.err.println(claims.getId());
        System.err.println(claims.getSubject());
        System.err.println(claims.getExpiration());
    }
}

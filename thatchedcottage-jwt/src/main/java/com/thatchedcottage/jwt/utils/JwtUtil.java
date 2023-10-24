package com.thatchedcottage.jwt.utils;

import com.thatchedcottage.user.domain.User;
import io.jsonwebtoken.*;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

/**
 * @program: thatchedcottage
 * @description: Jwt工具类
 * @author:
 * @create: 2023-10-07 14:56
 **/
public class JwtUtil {

    /*一个小时*/
    private static long time = 1000 * 60 * 60 * 1;

    private static String sign = "admin";

    /*生成token*/
    public static String createToken(User user) {
        /*1: 创建 JwtBuilder 对象*/
        JwtBuilder jwtBuilder = Jwts.builder();
        /*2: 生成JwtToken -> abc.def.xyz*/
        String jwtToken = jwtBuilder
                /*Header 头部*/
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")

                /*Payload：载荷 负载*/
                .claim("username",user.getLoginName())
                .claim("role",user.getNickName())
                .setSubject(user.getSalt())

                /*设置 ID 字段*/
                .setId(UUID.randomUUID().toString())
                /*Token 过期时间*/
                .setExpiration(new Date(System.currentTimeMillis() + time))
                /*设置签名 Signatrue*/
                /* 设置加密算法 及 签名*/
                .signWith(SignatureAlgorithm.HS256,sign)
                /* 使用 “.” 连接成一个完整的字符串*/
                .compact();
        return jwtToken;
    }

    /*验证Token是否过期*/
    public static boolean checkToken(String token) {
        if (token == null || token == ""){
            return false;
        }
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(sign).parseClaimsJws(token);
        }catch (Exception e){
            //e.printStackTrace();
            return false;
        }
        return true;
    }

}

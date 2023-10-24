package com.thatchedcottage.jwt.controller;
import cn.hutool.http.server.HttpServerRequest;
import com.thatchedcottage.jwt.domain.UserVo;
import com.thatchedcottage.jwt.utils.JwtUtil;
import com.thatchedcottage.user.domain.User;
import com.thatchedcottage.user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: thatchedcottage
 * @description: 用户Jwt
 * @author:
 * @create: 2023-10-07 14:50
 **/
@RestController
@RequestMapping("/jwt")
public class UserJwtController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/userJwt")
    public UserVo getUser(String id) {
        User byId = userService.getById(id);
        if (byId == null){
            return null;
        }
        UserVo userVo = setToken(byId);

        boolean b = checkToken(userVo);

        return userVo;
    }

    public static UserVo setToken(User user) {
        UserVo userVo = new UserVo(null);
        BeanUtils.copyProperties(user,userVo);
        userVo.setToken(JwtUtil.createToken(user));
        return userVo;
    }

    /*验证Token是否过期*/
    public static boolean checkToken(UserVo userVo) {
        boolean b = JwtUtil.checkToken(userVo.getToken());
        System.err.println(b);
        return b;
    }
    /*验证Token是否过期*/
    public static boolean checkToken(HttpServerRequest request) {
        String token = request.getHeader("token");
        boolean b = JwtUtil.checkToken(token);
        System.err.println(b);
        return b;
    }

}

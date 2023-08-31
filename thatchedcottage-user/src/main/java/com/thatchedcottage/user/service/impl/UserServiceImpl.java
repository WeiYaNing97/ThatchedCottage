package com.thatchedcottage.user.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thatchedcottage.user.domain.User;
import com.thatchedcottage.user.mapper.UserMapper;
import com.thatchedcottage.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService{
}

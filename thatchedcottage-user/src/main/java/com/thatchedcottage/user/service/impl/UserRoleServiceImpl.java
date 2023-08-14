package com.thatchedcottage.user.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thatchedcottage.user.domain.UserRole;
import com.thatchedcottage.user.mapper.UserRoleMapper;
import com.thatchedcottage.user.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper,UserRole> implements IUserRoleService{
}

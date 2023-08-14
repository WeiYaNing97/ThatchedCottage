package com.thatchedcottage.user.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thatchedcottage.user.domain.Role;
import com.thatchedcottage.user.mapper.RoleMapper;
import com.thatchedcottage.user.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements IRoleService{
}

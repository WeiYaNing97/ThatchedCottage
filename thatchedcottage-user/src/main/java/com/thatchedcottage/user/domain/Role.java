package com.thatchedcottage.user.domain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "role")
public class Role{
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String roleName;
    
    public Role(Role role) {
        if (Objects.nonNull(role)) {
            this.id=role.id;
            this.roleName=role.roleName;
        }
    }
}

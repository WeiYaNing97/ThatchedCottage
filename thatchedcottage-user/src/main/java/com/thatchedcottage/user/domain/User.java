package com.thatchedcottage.user.domain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
/** 用户表 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "sh_user")
public class User{
    private static final long serialVersionUID = 1L;
    private String address;
    private String duties;
    private String email;
    private String enableFlag;
    @TableId(type = IdType.AUTO)
    private String id;
    private String loginName;
    private String mobil;
    private String nickName;
    private String passWord;
    private String realName;
    private String salt;
    private Integer sex;
    private Integer sortNo;
    private String tel;
    private String zipcode;
    
    public User(User user) {
        if (Objects.nonNull(user)) {
            this.address=user.address;
            this.duties=user.duties;
            this.email=user.email;
            this.enableFlag=user.enableFlag;
            this.id=user.id;
            this.loginName=user.loginName;
            this.mobil=user.mobil;
            this.nickName=user.nickName;
            this.passWord=user.passWord;
            this.realName=user.realName;
            this.salt=user.salt;
            this.sex=user.sex;
            this.sortNo=user.sortNo;
            this.tel=user.tel;
            this.zipcode=user.zipcode;
        }
    }
}

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
    @TableId(type = IdType.AUTO)
    private String id;
    private String loginName;
    private String realName;
    private String nickName;
    private String passWord;
    private String salt;
    private Integer sex;
    private String zipcode;
    private String address;
    private String tel;
    private String mobil;
    private String email;
    private String duties;
    private Integer sortNo;
    private String enableFlag;
    
    public User(User user) {
        if (Objects.nonNull(user)) {
            this.id=user.id;
            this.loginName=user.loginName;
            this.realName=user.realName;
            this.nickName=user.nickName;
            this.passWord=user.passWord;
            this.salt=user.salt;
            this.sex=user.sex;
            this.zipcode=user.zipcode;
            this.address=user.address;
            this.tel=user.tel;
            this.mobil=user.mobil;
            this.email=user.email;
            this.duties=user.duties;
            this.sortNo=user.sortNo;
            this.enableFlag=user.enableFlag;
        }
    }
}

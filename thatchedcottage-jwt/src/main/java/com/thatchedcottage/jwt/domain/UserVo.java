package com.thatchedcottage.jwt.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/** 用户表 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "sh_user")
public class UserVo {
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
    private String token;

    public UserVo(UserVo user) {
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
            this.token=user.token;
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

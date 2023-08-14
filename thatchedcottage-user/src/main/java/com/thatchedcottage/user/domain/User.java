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
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user")
public class User{
    private static final long serialVersionUID = 1L;
    private Integer age;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    
    public User(User user) {
        if (Objects.nonNull(user)) {
            this.age=user.age;
            this.id=user.id;
            this.name=user.name;
        }
    }
}

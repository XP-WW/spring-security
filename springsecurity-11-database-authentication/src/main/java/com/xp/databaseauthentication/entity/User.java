package com.xp.databaseauthentication.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 14:42
 * @since 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {
    private Integer userId;
    private String username;
    private String password;
    private String sex;
    private String address;
    private Integer enabled;
    private Integer accountNoExpired;
    private Integer credentialsNoExpired;
    private Integer accountNoLocked;
}

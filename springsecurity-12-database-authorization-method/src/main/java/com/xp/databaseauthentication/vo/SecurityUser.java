package com.xp.databaseauthentication.vo;

import com.xp.databaseauthentication.entity.User;
import com.xp.databaseauthentication.service.MenuService;
import com.xp.databaseauthentication.service.impl.MenuServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 15:17
 * @since 1.0
 **/
public class SecurityUser implements UserDetails {
    private final  User user;
    private List<SimpleGrantedAuthority> authorityList;
    public SecurityUser(User user){
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    public void setAuthorityList(List<SimpleGrantedAuthority> authorityList) {
        this.authorityList = authorityList;
    }

    @Override
    public String getPassword() {
        String myPassWord = user.getPassword();
        user.setPassword(null);
        return  myPassWord;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getAccountNoExpired().equals(1);
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getAccountNoLocked().equals(1);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getCredentialsNoExpired().equals(1);
    }

    @Override
    public boolean isEnabled() {
        return user.getEnabled().equals(1);
    }
}

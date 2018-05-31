package com.github.dgarcia202.springcrm.services;

import com.github.dgarcia202.springcrm.dataaccess.entities.Authority;
import com.github.dgarcia202.springcrm.dataaccess.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CrmUserPrincipal implements UserDetails {

    private User user;

    private List<Authority> authorities = new ArrayList<>();

    public CrmUserPrincipal(User user, List<Authority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.stream().map(x -> new CrmUserAuthority(x)).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }
}

package com.github.dgarcia202.springcrm.services;

import com.github.dgarcia202.springcrm.dataaccess.entities.Authority;
import org.springframework.security.core.GrantedAuthority;

public class CrmUserAuthority implements GrantedAuthority {

    private Authority authority;

    public CrmUserAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority.getAuthority();
    }
}

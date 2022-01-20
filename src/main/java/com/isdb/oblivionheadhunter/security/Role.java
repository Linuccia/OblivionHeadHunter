package com.isdb.oblivionheadhunter.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class Role implements GrantedAuthority {

    private String name;

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }

}

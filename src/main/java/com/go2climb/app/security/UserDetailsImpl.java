package com.go2climb.app.security;

import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
public class UserDetailsImpl<T> implements UserDetails {

    private final T user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        if (user instanceof Tourist) {
            return ((Tourist) user).getPassword();
        } else{
            return ((Agency) user).getPassword();
        }
    }

    @Override
    public String getUsername() {
        if (user instanceof Tourist) {
            return ((Tourist) user).getEmail();
        } else{
            return ((Agency) user).getEmail();
        }
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
        return true;
    }

    public String getName() {
        if (user instanceof Tourist) {
            return ((Tourist) user).getName();
        } else{
            return ((Agency) user).getName();
        }
    }
}

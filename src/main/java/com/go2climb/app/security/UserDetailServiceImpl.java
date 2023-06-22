package com.go2climb.app.security;

import com.go2climb.app.tourist.domain.model.entity.Tourist;
import com.go2climb.app.tourist.domain.persistence.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private TouristRepository touristRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Tourist tourist = touristRepository
                .findOneByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + username +" no existe."));
        return new UserDetailsImpl(tourist);
    }
}
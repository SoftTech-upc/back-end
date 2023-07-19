package com.go2climb.app.security;

import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.agency.domain.persistence.AgencyRepository;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import com.go2climb.app.tourist.domain.persistence.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private TouristRepository touristRepository;

    @Autowired
    private AgencyRepository agencyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Object tourist;

        Optional<Tourist> touristOptional = touristRepository.findOneByEmail(username);
        Optional<Agency> agencyOptional = agencyRepository.findOneByEmail(username);

        if (touristOptional.isPresent()) {
            tourist = touristOptional.get();
        } else if (agencyOptional.isPresent()) {
            tourist = agencyOptional.get();
        } else {
            throw new UsernameNotFoundException("El usuario con email " + username + " no existe.");
        }

        return new UserDetailsImpl(tourist);
    }
}



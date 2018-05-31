package com.github.dgarcia202.springcrm.services;

import com.github.dgarcia202.springcrm.dataaccess.entities.Authority;
import com.github.dgarcia202.springcrm.dataaccess.entities.User;
import com.github.dgarcia202.springcrm.dataaccess.repositories.AuthorityRepository;
import com.github.dgarcia202.springcrm.dataaccess.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    public static Logger logger = LogManager.getLogger(CustomUserDetailsService.class);

    private UserRepository userRepository;

    private AuthorityRepository authorityRepository;

    public CustomUserDetailsService(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("Applying custom authorization for user {}", username);

        Optional<User> user = userRepository.findById(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(String.format("User identified by '{}' not found", username));
        }

        List<Authority> authorities = authorityRepository.findByusername(user.get().getUsername());
        authorities.forEach(x -> logger.info("Auth +++ {} : {}", x.getUsername(), x.getAuthority()));

        return new CrmUserPrincipal(user.get(), authorities);
    }
}

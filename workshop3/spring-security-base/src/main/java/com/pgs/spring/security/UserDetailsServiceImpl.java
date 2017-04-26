package com.pgs.spring.security;

import java.util.Arrays;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author wszybisty
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        switch(username) {
            case "user":
                return new User("user", "user", 
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
            case "admin":
                return new User("admin", "admin", 
                        Arrays.asList(
                                new SimpleGrantedAuthority("ROLE_USER"),
                                new SimpleGrantedAuthority("ROLE_ADMIN")
                        ));
            default:
                return null;
        }
    }
    
}

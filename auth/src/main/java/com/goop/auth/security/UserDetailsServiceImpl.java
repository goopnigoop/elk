package com.goop.auth.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Qualifier("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final List<AppUser> users;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailsServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        users = Arrays.asList(
                new AppUser(1, "user", bCryptPasswordEncoder.encode("user"), "USER"),
                new AppUser(2, "admin", bCryptPasswordEncoder.encode("admin"), "ADMIN")
        );
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        for(AppUser appUser: this.users) {
            if(appUser.getUsername().equals(userName)) {
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());
                return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
            }
        }

        // If user not found. Throw this exception.
        throw new UsernameNotFoundException("Username: " + userName + " not found");
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class AppUser {
        private Integer id;
        private String username, password;
        private String role;
    }
}

package com.goop.auth.security;

import com.goop.auth.models.AppUser;
import com.goop.auth.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private AppUserRepository appUserRepository;

    public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        final AppUser appUser = appUserRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Username: " + userName + " not found"));

        List<GrantedAuthority> grantedAuthorities = appUser.getAuthoritySet()
                .stream()
                .map(auth -> "ROLE_" + auth)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
    }
}

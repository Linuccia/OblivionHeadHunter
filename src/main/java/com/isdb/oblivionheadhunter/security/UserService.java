package com.isdb.oblivionheadhunter.security;

import com.isdb.oblivionheadhunter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User doesn't exist");
        if (user.getRoleDB().equals("глава")) user.setRoles(Collections.singleton(new Role("ROLE_ADMIN")));
        else user.setRoles(Collections.singleton(new Role("ROLE_USER")));
        return user;
    }

}

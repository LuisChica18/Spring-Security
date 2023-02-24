package com.example.springsecurityjpauserrole.config;

import com.example.springsecurityjpauserrole.model.Authorities;
import com.example.springsecurityjpauserrole.model.Users;
import com.example.springsecurityjpauserrole.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
public class MyUsersDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> userByUsername = usersRepository.findByUsername(username);
        if (!userByUsername.isPresent()) {
            log.error("Could not find user with that username: {}", username);
            throw new UsernameNotFoundException("Invalid credentials!");
        }
        Users user = userByUsername.get();
        if (user == null || !user.getUsername().equals(username)) {
            log.error("Could not find user with that username: {}", username);
            throw new UsernameNotFoundException("Invalid credentials!");
        }
        Set<Authorities> authorities = new HashSet<Authorities>();
        for (Authorities authority : user.getAuthorities()) {
            authorities.add(authority);
        }
        user.setAuthorities(authorities);
        return (UserDetails) new MyUsersDetails(user);
    }
}

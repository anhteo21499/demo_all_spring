package com.example.v4.securities;

import com.example.v4.models.Users;
import com.example.v4.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findUsersByUserName(username);

        if(users == null)
        throw new UsernameNotFoundException("Could not found user : " + username);
        
        return new MyUserDetail(users);
    }
}

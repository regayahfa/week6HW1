package com.example.week6hw1.Servis;

import com.example.week6hw1.Repostry.UserRepostry;
import com.example.week6hw1.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserSiervis implements UserDetailsService {
private final UserRepostry userRepostry;

public List<User> getAllUser(){
    return userRepostry.findAll();
}

    public void  reggister(User user){

        userRepostry.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}

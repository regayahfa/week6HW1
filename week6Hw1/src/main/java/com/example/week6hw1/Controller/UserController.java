package com.example.week6hw1.Controller;

import com.example.week6hw1.Servis.UserSiervis;
import com.example.week6hw1.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserSiervis userSiervis;


    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        List<User>userList=userSiervis.getAllUser();
        return ResponseEntity.status(200).body(userList);
    }

    @PostMapping("/reggister")
    public ResponseEntity reggister(@RequestBody User user){
        userSiervis.reggister(user);
        return ResponseEntity.status(200).body("user reggister");
    }


    @PostMapping("/user")
    public ResponseEntity user(){
        return ResponseEntity.status(200).body("welcome user");
    }

    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body("login");
    }

    @PostMapping("/logout")
    public ResponseEntity logout(){
        return ResponseEntity.status(200).body("logout");
    }


}

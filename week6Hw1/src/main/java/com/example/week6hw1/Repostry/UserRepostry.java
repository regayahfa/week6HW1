package com.example.week6hw1.Repostry;

import com.example.week6hw1.model.Blog;
import com.example.week6hw1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepostry extends JpaRepository<User, Integer> {
User findUsersByBlogs(Blog blog);
//    User findUserByUsername(String username);
}

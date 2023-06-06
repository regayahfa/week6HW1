package com.example.week6hw1.Repostry;

import com.example.week6hw1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepostry extends JpaRepository<Blog, Integer> {

//   Blog findBlogById();
    List<Blog> findBlogById();
List<Blog> findBlogByTitle(String titlr);
    Blog findBlogById(Integer blogId);
}

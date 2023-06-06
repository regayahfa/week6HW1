package com.example.week6hw1.Controller;

import com.example.week6hw1.Servis.BlogServis;
import com.example.week6hw1.model.Blog;
import com.example.week6hw1.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/Api/v1/blog")
@RestController
public class BlogContriller {

    private final BlogServis blogServis;

    @GetMapping("/get")
    public ResponseEntity getBlog(@AuthenticationPrincipal User user){

        List<Blog> blog=blogServis.getBlog(user.getId());

        return ResponseEntity.status(200).body(blog);
    }

    @PostMapping("/add")
    public ResponseEntity addblog(@AuthenticationPrincipal User user, @RequestBody Blog blog){
        blogServis.addblog(user.getId(), blog);

        return ResponseEntity.status(200).body("todo added");
    }
    @PutMapping ("/updateBlog/{blogId}")
    public ResponseEntity updateBlog(@AuthenticationPrincipal User user,@RequestBody Blog blog, @PathVariable Integer BlogId ){

        blogServis.updateBlog(user.getId(),blog,BlogId);

        return ResponseEntity.status(200).body("TODO UPDATE");
    }

    @DeleteMapping("/deleteBlog/{BlogId}")
    public ResponseEntity daleteBlog(@AuthenticationPrincipal User user,@PathVariable Integer blogId){

        blogServis.deleteBlog(user.getId(),blogId);
        return ResponseEntity.status(200).body("blog is deleted");
    }

//endpoint
    @GetMapping("/get-user")
    public Blog getUsersByBlogs(@AuthenticationPrincipal User user, Blog Blog){
       List<Blog>userList=blogServis.getBlog(user);
       return Blog;
    }
    @GetMapping("/get-title")
    public Blog getBlogByTitle(@AuthenticationPrincipal Blog blog, Blog title){
        List<Blog>blogs=blogServis.getBlog(blog.getUserId());
        return blog;
    }


}

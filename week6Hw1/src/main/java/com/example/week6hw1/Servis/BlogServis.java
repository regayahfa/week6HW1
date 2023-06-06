package com.example.week6hw1.Servis;

import com.example.week6hw1.ApiEXciption.ApiExciption;
import com.example.week6hw1.Repostry.BlogRepostry;
import com.example.week6hw1.model.Blog;
import com.example.week6hw1.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogServis {
    private final BlogRepostry blogRepostry;

    public List<Blog> getBlog(Integer user) {
        return blogRepostry.findBlogById();
    }


    public void addblog(Integer user, Blog blog) {
        blog.setUserId(blog.getUserId());
    }

    public void updateBlog(Integer id, Blog blog, Integer blogId) {
        Blog oldBlog=blogRepostry.findBlogById(blogId);
        if (oldBlog==null){
            throw new ApiExciption("Blog not fuond");
        }
        if (oldBlog.getUserId()!=blogId){
            throw new ApiExciption("error, ");
        }
        oldBlog.setUserId(blog.getUserId());
        blogRepostry.save(oldBlog);
    }
    public void deleteBlog(Integer userId, Integer BlogId) {
        Blog oldblog=blogRepostry.findBlogById(userId);

        if (oldblog.getUserId()!=userId){
            throw new ApiExciption("error, ");
        }
        blogRepostry.save(oldblog);
    }

    public List<Blog> getBlog(User user) {
        return blogRepostry.findBlogById();

    }

    public List<Blog> getBlogByTitle(Integer userId, String title) {
        return blogRepostry.findBlogByTitle(title);
    }
}


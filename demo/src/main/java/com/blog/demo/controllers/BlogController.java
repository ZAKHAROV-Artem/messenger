package com.blog.demo.controllers;

import com.blog.demo.models.Post;
import com.blog.demo.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class BlogController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blog(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("title", "Блог");
        return "blog";
    }
    @PostMapping("/blog")
    public String blogPost(@RequestParam String text, Model model){
        Post post = new Post(text);
        postRepository.save(post);
        return "redirect:/blog";
    }
//    @PostMapping("/blog/{id}/remove")
//    public String blogPostDelete(@PathVariable(value = "id") long id, Model model){
//        Post post = postRepository.findById(id).orElseThrow();
//        postRepository.delete(post);
//        return "redirect:/blog";
//    }

}

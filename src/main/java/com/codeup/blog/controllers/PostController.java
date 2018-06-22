/*
GET	/posts	posts index page
GET	/posts/{id}	view an individual post
GET	/posts/create	view the form for creating a post
POST	/posts/create	create a new post
*/
package com.codeup.blog.controllers;
import com.codeup.blog.models.Post;
import com.codeup.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private PostService postService;

    // PostController constructor
    // Dependency Injection

    public PostController(PostService postService) {

        this.postService = postService;
    }

    // mappings are the url
    @GetMapping("/posts")
    public String index(Model view) {
        view.addAttribute("posts", postService.findAll());

        // relative path for the .html file inside of resources/templates w/o the .html
        return "/posts/index";
    }


    @GetMapping("/posts/{id}")
    public String showDetails(@PathVariable long id, Model view) {
        Post post = postService.findOne(id);
        view.addAttribute("post", post);
        postService.save(post);

        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model view) {
        view.addAttribute("post", postService.findOne(id));


        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String refresh(@ModelAttribute Post post){
        postService.update(post);

        return "redirect:/posts";
    }



    @GetMapping("/posts/create")
    public String create(Model view) {
//        add a new posts
        view.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(@ModelAttribute Post post) {
        postService.save(post);

        System.out.println("post.title:" + post.getTitle());
        System.out.println("post.body:" + post.getBody());
        return "redirect:/posts";
    }


}

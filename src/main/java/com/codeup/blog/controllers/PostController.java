/*
GET	/posts	posts index page
GET	/posts/{id}	view an individual post
GET	/posts/create	view the form for creating a post
POST	/posts/create	create a new post
*/
package com.codeup.blog.controllers;
import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.UserRepo;
import com.codeup.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {


//    this is where you need to declare a data access object
    private PostService postService;

    private UserRepo userRepo;



    // PostController constructor
    // Dependency Injection

    @Autowired
    public PostController(PostService postService, UserRepo userRepo) {

        this.postService = postService;
        this.userRepo = userRepo;
    }



    // mappings are the url
    @GetMapping("/posts")
    public String index(Model view) {
        view.addAttribute("posts", postService.findAll());
        // relative path for the .html file inside of resources/templates w/o the .html
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String showDetails(@PathVariable long id, Model view) {
        Post post = postService.findOne(id);
        view.addAttribute("post", post);
        postService.save(post);

        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@ModelAttribute Post post,@PathVariable long id, Model view) {
        post.setId(id);
        view.addAttribute("post", postService.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String refresh(@ModelAttribute Post post){
        postService.save(post);

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

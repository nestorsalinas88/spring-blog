/*
GET	/posts	posts index page
GET	/posts/{id}	view an individual post
GET	/posts/create	view the form for creating a post
POST	/posts/create	create a new post
*/
package com.codeup.blog.controllers;
import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UserRepo;
import com.codeup.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostController {


//    this is where you need to declare a data access object
    private final PostService postService;

    private final UserRepo userRepo;



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

//        where is this going? ||

        postService.save(post);

        return "posts/show";
    }



    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model view) {

        User session = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepo.findById(session.getId());
        Post post = postService.findOne(id);

        if(post.getUser().getId() == user.getId()){
            view.addAttribute("post", post);
            return "posts/edit";
        } else  {

            return "redirect:/posts";
        }

    }

    @PostMapping("/posts/{id}/edit")
    public String refresh(@Valid Post post, @PathVariable long id){


            post.setUser(postService.findOne(id).getUser());
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

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
//
//        System.out.println("post.title:" + post.getTitle());
//        System.out.println("post.body:" + post.getBody());

        postService.save(post);
        return "redirect:/posts";
    }


}

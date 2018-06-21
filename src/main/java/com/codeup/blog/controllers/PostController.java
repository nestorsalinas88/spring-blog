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

        List<Post> posts = postService.findAll();

        view.addAttribute("posts", posts);

        // relative path for the .html file inside of resources/templates w/o the .html
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String showDetails(@PathVariable long id, Model view) {

        Post post = postService.findOne(id);

        view.addAttribute("post", post);

        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public @ResponseBody String edit(@PathVariable long id) {
        return "View the form for editing post #" + id;
    }

    @GetMapping("/posts/create")
    public String create(Model view) {
//        add a new posts
        view.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public @ResponseBody String savePost(@ModelAttribute Post post) {

        System.out.println("post.title:" + post.getTitle());
        return "posts/index";
    }


}

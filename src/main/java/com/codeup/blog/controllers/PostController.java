/*
GET	/posts	posts index page
GET	/posts/{id}	view an individual post
GET	/posts/create	view the form for creating a post
POST	/posts/create	create a new post
*/
package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.PostRepo;
import com.codeup.blog.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PostController {


    //    this is where you need to declare a data access object
    private final PostRepo postDao;

    private final UserRepo userRepo;

    // PostController constructor
    // Dependency Injection

    public PostController(PostRepo postRepo, UserRepo userRepo) {
        this.postDao = postRepo;
        this.userRepo = userRepo;
    }

    // mappings are the url
    @GetMapping("/posts")
    public String index(Model vModel) {
        Iterable<Post> posts = postDao.findAll();
        vModel.addAttribute("posts", posts);
        // relative path for the .html file inside of resources/templates w/o the .html
        return "posts/index";
    }


    //
    @GetMapping("/posts/{id}")
    public String showDetails(@PathVariable long id, Model view) {
        Post post = postDao.findOne(id);
        view.addAttribute("post", post);

//        where is this going? ||

        postDao.save(post);

        return "posts/show";
    }

    @GetMapping("/posts/error")
    public String Error() {
        return "posts/error";


    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model vModel) {

        Post post = postDao.findOne(id);
        vModel.addAttribute("post", post);
        return "posts/edit";

    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable long id,
                         @RequestParam(name = "title") String title,
                         @RequestParam(name = "body") String body,
                         Model vModel) {

        Post postUpdate = postDao.findOne(id);
        postUpdate.setTitle(title);
        postUpdate.setBody(body);
        postDao.save(postUpdate);
        return "redirect:/posts/" + postUpdate.getId();

    }



    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id){
        postDao.delete(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String create(Model view) {
//        add a new posts
        view.addAttribute("action", "/posts/create");
        view.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost() {



        return "home";
    }



}

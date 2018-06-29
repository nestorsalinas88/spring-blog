/*
GET	/posts	posts index page
GET	/posts/{id}	view an individual post
GET	/posts/create	view the form for creating a post
POST	/posts/create	create a new post
*/
package com.codeup.blog.controllers;
import com.codeup.blog.models.Document;
import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.Documents;
import com.codeup.blog.repositories.UserRepo;
import com.codeup.blog.services.PostService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {


//    this is where you need to declare a data access object
    private final PostService postService;

    private final UserRepo userRepo;

    private final Documents docDao;




    // PostController constructor
    // Dependency Injection

    @Autowired
    public PostController(PostService postService, UserRepo userRepo, Documents docDao) {

        this.postService = postService;
        this.userRepo = userRepo;
        this.docDao = docDao;

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

    @GetMapping("/posts/error")
    public String Error(){
        return "posts/error";


    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model view) {

        User session = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepo.findById(session.getId());
        Post post = postService.findOne(id);

        if(post.getUser().getId() == user.getId()){
            view.addAttribute("post", post);
            return "posts/edit";
        } else if (post.getUser().getId() != user.getId()){
            return "redirect:/posts/error";
        }

        else  {

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
        view.addAttribute("action", "/posts/create");
        view.addAttribute("post", new Post());
        view.addAttribute("docs", "");
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(@Valid Post post, Errors validation, @RequestParam("post-documents") String attach, Model view) throws IOException{


        List<Document> documents = new ArrayList<>();

        if(attach.length() > 1) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode docs = mapper.readTree(attach);

            for (JsonNode doc : docs) {
                System.out.println("found doc");
                Document document = new Document(doc.get("fileName").toString(),doc.get("fileName").toString(),doc.get("fileSize").longValue());
                documents.add(document);
            }

        }

        if (post.getTitle().endsWith("?")) {
            validation.rejectValue(
                    "title",
                    "post.title",
                    "You can't be unsure about your title!"
            );
        }

        if(validation.hasErrors()) {
            view.addAttribute("errors", validation);
            view.addAttribute("post", post);
            view.addAttribute("docs", attach);
            return "/posts/create";
        } else {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            post.setUser(user);
            postService.save(post);
            post.setDocuments(documents);
            docDao.save(post.getDocuments());
            return "redirect:/posts";
        }
    }


}

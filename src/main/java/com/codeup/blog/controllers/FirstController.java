package com.codeup.blog.controllers;


import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    private PostRepo postDao;

    public FirstController(PostRepo postRepo) {
        this.postDao = postRepo;
    }

    @GetMapping("/")
    public String indexView(Model vModel){
        Iterable<Post> posts = postDao.findAll();
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }


//    @GetMapping("/say-hello")
//    public @ResponseBody String firstView(){
//        return "Hello from spring!";
//    }
//
//    @GetMapping("/say-hello/{name}")
//    public @ResponseBody String sayHello(@PathVariable("name") String name){
//        return String.format("Hello, %s!", name);
//    }
//
//
//    @GetMapping("/say-goodbye")
//    public @ResponseBody String lastView(){
//        return "goodbye World!";
//    }
//
//    @GetMapping("/flights/from/{from}/to/{to}")
//    public @ResponseBody String getFlights(
//            @PathVariable String from,
//            @PathVariable String to
//    ){
//        return String.format("finding flights from %s to %s...", from, to);
//    }
//
//
//    @GetMapping("/increment/{n}")
//    public @ResponseBody String increment(@PathVariable int n){
//        return String.format("%d + 1 = %d", n, n + 1);
//    }

}

package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {

    @GetMapping("/home")
    public String welcome(){
        return "home";
    }


    @GetMapping("/home/{name}")
    public String welcomeUser(
            @PathVariable String name,
            Model model
    ){
        model.addAttribute("name", name);
        return "home";
    }



    @GetMapping("/home/users")
    public String welcomeUsers(Model model){
        List<String> users = new ArrayList<>();
        users.add("Nestor");
        users.add("Jake");
        users.add("Brain");
        users.add("John");

        model.addAttribute("users", users);
        return "home";


    }




}



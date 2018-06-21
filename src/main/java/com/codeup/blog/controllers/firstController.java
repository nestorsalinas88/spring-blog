package com.codeup.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class firstController {

    @GetMapping("/say-hello")
    public @ResponseBody String firstView(){
        return "Hello from spring!";
    }

    @GetMapping("/say-hello/{name}")
    public @ResponseBody String sayHello(@PathVariable("name") String name){
        return String.format("Hello, %s!", name);
    }


    @GetMapping("/say-goodbye")
    public @ResponseBody String lastView(){
        return "goodbye World!";
    }

    @GetMapping("/flights/from/{from}/to/{to}")
    public @ResponseBody String getFlights(
            @PathVariable String from,
            @PathVariable String to
    ){
        return String.format("finding flights from %s to %s...", from, to);
    }


    @GetMapping("/increment/{n}")
    public @ResponseBody String increment(@PathVariable int n){
        return String.format("%d + 1 = %d", n, n + 1);
    }

}

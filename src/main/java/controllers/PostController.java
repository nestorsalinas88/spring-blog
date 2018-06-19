/*
GET	/posts	posts index page
GET	/posts/{id}	view an individual post
GET	/posts/create	view the form for creating a post
POST	/posts/create	create a new post
*/
package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
       @ResponseBody public String index() {
        return "post index page";
       }


     @GetMapping("/posts/{id}")
     @ResponseBody public String show(@PathVariable long id)
     {
         return "post numbers: " + id;
     }


     @GetMapping("/posts/create")
     @ResponseBody public String create()
     {
         return "view the form for creating a post";
     }



     @PostMapping("/posts/create")
     @ResponseBody public String insert() {

        return "create a new post";

    }


}


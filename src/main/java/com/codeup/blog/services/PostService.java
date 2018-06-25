package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PostService {
    private List<Post> posts;

    private void createPosts() {
        posts.add(new Post(1, "This is a title", "this is the body!"));
        posts.add(new Post(2, "This is a title", "this is the body!"));
        posts.add(new Post(3, "This is a title", "this is the body!"));
        posts.add(new Post(4, "This is a title", "this is the body!"));
        posts.add(new Post(5, "This is a title", "this is the body!"));
        posts.add(new Post(6, "This is a title", "this is the body!"));
        posts.add(new Post(7, "This is a title", "this is the body!"));
    }

    public PostService() {
        this.posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }


    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {

        return posts.get((int) id - 1);
    }

    public void update(Post post){
        posts.add(post);

    }



//    public List<Post> search(String searchTerm){
//        return posts.de("%" + searchTerm + "%");
//    }

}
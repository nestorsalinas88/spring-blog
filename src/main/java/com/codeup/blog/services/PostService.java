package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        this.posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll() {

        return posts;
    }
    public Post getPost(long id){
        return posts.get((int) id - 1);
    }


    private void createPosts() {
        posts.add(new Post(1, "This is a title", "10 of them!"));
        posts.add(new Post(2, "This is a title", "The answers are true!"));
        posts.add(new Post(3, "hello This is a title", "How many tutorials start off w/ hello world!"));
        posts.add(new Post(4, "This is a title", "lol jk, here's a story about my family"));
        posts.add(new Post(5, "This is a title", "You won't believe number 3"));
        posts.add(new Post(6, "This is a title", "Programming is a way of thinking"));
        posts.add(new Post(7, "This is a title", "We become what we think about"));
    }


    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return posts.get((int) id - 1);
    }

}
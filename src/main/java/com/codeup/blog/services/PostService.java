package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PostService {

    private PostRepo postRepo;


    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public Iterable<Post> findAll() {
        return postRepo.findAll();
    }


    public Post save(Post post) {
        postRepo.save(post);
        return post;
    }

    public Post findOne(long id) {
        return postRepo.findOne(id);
    }

  public Post deactivateAd(long id, Post post){

      postRepo.findOne(id);
      postRepo.save(post);
      return post;


  }



//    public List<Post> search(String searchTerm){
//        return posts.de("%" + searchTerm + "%");
//    }

}
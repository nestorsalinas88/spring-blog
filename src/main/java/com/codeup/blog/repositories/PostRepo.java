package com.codeup.blog.repositories;

import com.codeup.blog.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {
    Post findByTitle(String title);


//
//    @Query(nativeQuery = true, value = "SELECT * FROM posts WHERE title LIKE ?1 OR body LIKE ?1")
//
//
//
//    List<Post> search(String searchTerm) throws SQLException;
//
//
//    List<Post> posts = Post.findAll();
//
//    void edit(String id, String title, String body, String status);





}

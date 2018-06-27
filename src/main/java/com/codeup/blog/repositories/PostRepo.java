package com.codeup.blog.repositories;

import com.codeup.blog.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.sql.SQLException;
import java.util.List;

public interface PostRepo extends CrudRepository<Post, Long> {

//
//    @Query(nativeQuery = true, value = "SELECT * FROM posts WHERE title LIKE ?1 OR body LIKE ?1")
//
//
//    List<Post> search(String searchTerm) throws SQLException;
//
//    void edit(String id, String title, String body);
//
//    void edit(String id, String title, String body, String status);





}

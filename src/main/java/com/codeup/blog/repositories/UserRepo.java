package com.codeup.blog.repositories;

import com.codeup.blog.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long>{

        User findById(long id);

        User findByUsername(String name);

        @Query(nativeQuery = true, value = "SELECT * FROM users LIMIT 1")
        User first();


}

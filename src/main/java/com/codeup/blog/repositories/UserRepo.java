package com.codeup.blog.repositories;

import com.codeup.blog.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long>{

//    This is why I duggie!
    @Query(nativeQuery = true, value = "SELECT * FROM user LIMIT 1")

    User first();


}

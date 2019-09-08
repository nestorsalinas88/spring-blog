package com.codeup.blog.models;

import javax.persistence.*;
import java.util.List;


@Entity
//This tables name should be plural hence the multiple 'users'
@Table(name="user")
public class User {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer role;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> post;


    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        username = copy.username;
        email = copy.email;
        password = copy.password;
    }

    public User(long id, String username, String email, String password, int role) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.email = email;
        this.password = password;
    }

//    public User() {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

}

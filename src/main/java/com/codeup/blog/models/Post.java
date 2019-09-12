package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column(name = "status", columnDefinition = "boolean default true", nullable = false)
    private boolean status;

    @OneToOne
    private User user;


    // Useful to create a new instance
    public Post() {}


    // Constructor for everything for the R of (CRUD)
    public Post(long id, String title, String body, boolean status, User user){
        this.id = id;
        this.title = title;
        this.body = body;
        this.status = status;
        this.user = user;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}

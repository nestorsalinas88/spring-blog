package com.codeup.blog.models;


import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column(nullable = false)
    private int status;


    @ManyToOne @JoinColumn(name = "user_id")
    private User user;


    public Post() {}


    public Post(String title, String body) {
        this.title = title;
        this.body = body;

    }
    public Post(long id,String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;


    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public String getTitle() {

        return title;
    }

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

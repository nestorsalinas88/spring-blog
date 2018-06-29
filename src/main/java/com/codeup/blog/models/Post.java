package com.codeup.blog.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column
    private boolean status;


    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post")
    @JsonBackReference(value = "post-documents")
    private List<Document> documents;


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

    public Post(long id, String title, String body, boolean status, User user){
        this.id = id;
        this.title = title;
        this.body = body;
        this.status = status;
        this.user = user;



    }
    public Post(User user, String title, String body, List<Document> documents) {
        this.user = user;
        this.title = title;
        this.body = body;
        this.documents = documents;
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

    @JsonProperty
    public List<Document> getDocuments() { return documents; }


    public void addDocument(Document document) {
        this.documents.add(document);
    }


    public void setDocuments(List<Document> documents) {
        for(Document document : documents) {
            document.setPost(this);
        }
        this.documents = documents;
    }
}

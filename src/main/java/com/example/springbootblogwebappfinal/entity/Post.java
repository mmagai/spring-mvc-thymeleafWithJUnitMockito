package com.example.springbootblogwebappfinal.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    private String url;

    public Post(String title, String url, String content, String shortDescription, LocalDateTime createOn, LocalDateTime updateOn) {
        this.title = title;
        this.url = url;
        this.content = content;
        this.shortDescription = shortDescription;
        this.createOn = createOn;
        this.updateOn = updateOn;
    }

    @Lob
    @Column(nullable = false)
    private String content;

    private String shortDescription;


    @CreationTimestamp
    private LocalDateTime createOn;


    @CreationTimestamp
    private LocalDateTime updateOn;


}

package com.javaworld.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "posts",
        uniqueConstraints = {@UniqueConstraint(columnNames = "title")}
)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "content", nullable = false, unique = true)
    private String content;
    @OneToMany(mappedBy = "post", orphanRemoval = false,cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

}

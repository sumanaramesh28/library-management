package com.course.librarymanagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",length = 100,nullable = false,unique = true)
    private String name;

    @ManyToMany(mappedBy = "categories",cascade = CascadeType.ALL)
    private Set<Book> book = new HashSet<Book>();

    public Category(String name) {
        this.name = name;
    }
}

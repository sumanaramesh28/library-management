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
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "isbn",length = 50,nullable = false,unique = true)
    private String isbn;

    @Column(name = "name",length = 50,nullable = false)
    private String name;

    @Column(name = "description",length = 250,nullable = false)
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="books_authors",
            joinColumns ={@JoinColumn (name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="author_id")})
    private Set<Author> authors = new HashSet<Author>();


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="books_categories",
            joinColumns ={@JoinColumn (name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")})
    private Set<Category> categories = new HashSet<Category>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="books_publishers",
            joinColumns ={@JoinColumn (name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="publisher_id")})
    private Set<Publisher> publishers = new HashSet<Publisher>();

    public void RemovePublisher(Publisher publisher){
        this.publishers.remove(publisher);
        publisher.getBook().remove(publisher);
    }
    public void AddPublisher(Publisher publisher){
        this.publishers.add(publisher);
        publisher.getBook().add(this);
    }

    public void RemoveAuthor(Author author){
        this.authors.remove(author);
        author.getBook().remove(author);
    }
    public void AddAuthor(Author author){
        this.authors.add(author);
        author.getBook().add(this);
    }

    public void RemoveCategory(Category category){
        this.categories.remove(category);
        category.getBook().remove(category);
    }
    public void AddCategory(Category category){
        this.categories.add(category);
        category.getBook().add(this);
    }

    public Book(String isbn, String name, String description) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
    }
}

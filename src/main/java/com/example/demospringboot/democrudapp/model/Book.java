package com.example.demospringboot.democrudapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@Getter
//@Setter
//@AllArgsConstructor
@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "book_name",nullable = false)
    private String name;
    @Column(name = "book_author",nullable = false)
    private String author;
    @Column(name = "book_price",nullable = false)
    private double price;
    @Column(name = "book_isbn")
    private String isbn;
    private String category;

    //Many-to-many relationship with order entity
    @ManyToMany
    @JoinTable(name = "orders_books",
            joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"), //refera join cu cheia primara din tabela curenta(books)
            inverseJoinColumns = @JoinColumn(name = "order_id",referencedColumnName = "id")) // refera join cu FK-ul celeilalte tabele(orders)
    @JsonIgnoreProperties("bookList")
    private List<Order> orderList;


}

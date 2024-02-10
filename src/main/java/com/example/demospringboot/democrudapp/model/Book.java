package com.example.demospringboot.democrudapp.model;

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
    @ManyToMany(mappedBy = "bookList",fetch = FetchType.LAZY) //(default) lazy load -> incarcarea relatiei nu se va face imediat ci doar atunci cand e nevoie de ea,entitatile asociate sunt incarcate doar atunci cand sunt accesate prima data
    private List<Order> orderList;                             // eager load -> toate entitatile asociate sunt incarcate din baza de date simultan


}

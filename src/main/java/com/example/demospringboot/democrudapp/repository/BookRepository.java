package com.example.demospringboot.democrudapp.repository;

import com.example.demospringboot.democrudapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //reprezinta o interfata care gestioneaza entitatea(book) pentru a stoca si manipula date prin CRUD in DB
//o clasa extinde o alta clasa cu extends dar o clasa poate sa implementeze mai multe interfete cu implements
//o interfata poate extinde una sau mai multe interfete cu extends
public interface BookRepository extends JpaRepository<Book,Long> { //<Entitstea pe care se exewcuta CRUD , tipul cheii primare>
    // putem sa ne definim operatii CRUD custom
    //find all books by author
    List<Book> searchBooksByAuthor(String author);
    List<Book> searchBooksByNameAndPrice(String name, double price);
}

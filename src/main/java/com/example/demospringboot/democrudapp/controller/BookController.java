package com.example.demospringboot.democrudapp.controller;

import com.example.demospringboot.democrudapp.model.Book;
import com.example.demospringboot.democrudapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController //@RestController VS @Controller -> Spring rest api
@RequestMapping("/api/books")
public class BookController {
    //@RestController = @Controller + @ResponseBody
    //@RestController ofera suport pentru RestApi
    //Controller-ul e responsabil pentru a gestiona requesturile de HTTP care vin de la client(Aplicatia web) si de a returna un raspuns HTTP inapoi catre client
    //comunicarea intre frontend si backend e realizata prin protocolul HTTP de tipul request | response

    //dependency injection using annotation @RequiredArgsConstructor(DI through constructor)
    private final BookService bookService;


    //Implement HTTP rest apis(HTTP verbs):GET(@GetMapping) , POST(@PostMapping) , PUT(@PutMapping) , DELETE(@DeleteMapping)


    //GET endpoint -> http://localhost:8080/api/books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.readAllBooks(), HttpStatus.OK);
    };

    @GetMapping("/booksById")
    public ResponseEntity<Optional<Book>> getAllBooksById(Long id){
        return new ResponseEntity<>(bookService.getBookById(id),HttpStatus.OK);
    }

    @GetMapping("/booksByName")
    public ResponseEntity<List<Book>> getAllBooksByName(String name){
        return new ResponseEntity<>(bookService.getAllBooksByName(name),HttpStatus.OK);
    }

    @GetMapping("/booksByIsbn")
    public ResponseEntity<List<Book>> getAllBooksByIsbn(String isbn){
        return new ResponseEntity<>(bookService.getAllBooksByIsbn(isbn),HttpStatus.OK);
    }

}

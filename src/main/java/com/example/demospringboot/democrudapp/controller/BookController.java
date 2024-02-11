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

}

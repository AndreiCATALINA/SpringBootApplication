package com.example.demospringboot.democrudapp.controller;

import com.example.demospringboot.democrudapp.exception.ResourceNotFoundException;
import com.example.demospringboot.democrudapp.model.Book;
import com.example.demospringboot.democrudapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    //GET endpoint -> http://localhost:8081/api/books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> booksList = bookService.readAllBooks();
        if (booksList.isEmpty()) {
            throw new ResourceNotFoundException("No books found in DB");
        }
        return new ResponseEntity<>(booksList, HttpStatus.OK);
    }

    @GetMapping("/bookById/{id}") //http://localhost:8081/api/books/bookById/id
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id) {
        Optional<Book> bookById = bookService.getBookById(id);
        bookById.orElseThrow(() ->
                new ResourceNotFoundException("Book with id: " + id + " doesn't exist in DB"));
        return new ResponseEntity<>(bookById, HttpStatus.OK);
    }

    @GetMapping("/booksByName/{name}")
    public ResponseEntity<List<Book>> getAllBooksByName(@PathVariable String name) {
        List<Book> books = bookService.getAllBooksByName(name);
        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No books found width: " + name + " in DB");
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/booksByIsbn/{isbn}")
    public ResponseEntity<List<Book>> getAllBooksByIsbn(@PathVariable String isbn) {
        List<Book> booksByIsbn = bookService.getAllBooksByIsbn(isbn);
        if (booksByIsbn.isEmpty()) {
            throw new ResourceNotFoundException("No books found width: " + isbn + " in DB");
        }
        return new ResponseEntity<>(booksByIsbn, HttpStatus.OK);
    }


    //POST -> CREATE
    @PostMapping("/addNewBook") //http://localhost:8081/api/books/addNewBook
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book newBook = bookService.saveBook(book);  //varianta 2
        return new ResponseEntity<>(newBook, HttpStatus.OK);
    }

    @PutMapping("/updateBook")  //http://localhost:8081/api/books/updateBook
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        Optional<Book> bookOptional = bookService.getBookById(id);
        bookOptional.orElseThrow(() ->
                new ResourceNotFoundException("Book with id: " + id + " doesn't exist in DB"));
//        return ResponseEntity.status(HttpStatus.OK)
//                .body("Book with id: " + id + " deleted successfully");  //Varianta 1
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Book with id: " + id + " deleted successfully", HttpStatus.OK); // varianta 2

    }
    @ExceptionHandler(ResourceNotFoundException.class) //se foloseste pentru exceptii care sunt aruncate de controlere (trigger)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

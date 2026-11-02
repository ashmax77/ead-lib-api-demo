package edu.example.library_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.example.library_api.model.Book;
import edu.example.library_api.service.BookService;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService; 
  
    public BookController(BookService bookService) { 
        this.bookService = bookService; 
    }

    @GetMapping 
    public List<Book> getAllBooks() { 
        return bookService.getAllBooks(); 
    } 
  
    @GetMapping("/{id}") 
    public ResponseEntity<Book> getBookById(@PathVariable Long id) { 
        return bookService.getBookById(id) 
                .map(ResponseEntity::ok) 
                .orElse(ResponseEntity.notFound().build()); 
    } 
  
    @PostMapping 
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) { 
        return ResponseEntity.status(HttpStatus.CREATED) 
                .body(bookService.createBook(book)); 
    } 
  
    @PutMapping("/{id}") 
    public ResponseEntity<Book> updateBook(@PathVariable Long id, 
                                           @Valid @RequestBody Book book) { 
        return bookService.updateBook(id, book) 
                .map(ResponseEntity::ok) 
                .orElse(ResponseEntity.notFound().build()); 
    } 
  
    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) { 
        return bookService.deleteBook(id) 
                ? ResponseEntity.noContent().build() 
                : ResponseEntity.notFound().build(); 
    } 
}

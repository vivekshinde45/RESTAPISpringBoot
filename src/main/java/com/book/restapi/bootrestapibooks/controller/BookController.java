package com.book.restapi.bootrestapibooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.restapi.bootrestapibooks.entities.Book;
import com.book.restapi.bootrestapibooks.services.BookService;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = this.bookService.getAllBooks();
        if (books.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        Book book = this.bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book _book = this.bookService.addBook(book);
        if (_book != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(_book);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/book")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book _book = this.bookService.updateBook(book);
        if (_book != null) {
            return ResponseEntity.ok(_book);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") int id) {
        boolean isDeleted = this.bookService.deleteBook(id);
        if (isDeleted) {
            return ResponseEntity.ok("book " + id + " is deleted succesfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

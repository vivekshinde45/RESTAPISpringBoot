package com.book.restapi.bootrestapibooks.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.restapi.bootrestapibooks.dao.BookRepository;
import com.book.restapi.bootrestapibooks.entities.Book;

@Service
public class BookService {
    @Autowired
    private BookRepository _bookRepository;

    private static List<Book> list = new ArrayList<Book>();

    // static {
    // list.add(new Book(1, "java", "durgesh"));
    // list.add(new Book(2, ".net", "epsi"));
    // list.add(new Book(3, "AEM", "public"));
    // }

    // get all books
    public List<Book> getAllBooks() {
        List<Book> books = (List<Book>) this._bookRepository.findAll();
        return books;
    }

    // get book by id
    public Book getBookById(int bookID) {
        try {
            return this._bookRepository.findById(bookID);
        } catch (Exception ex) {
            return null;
        }
    }

    public Book getBookById0(int bookID) {
        Book book = null;
        for (Book _book : list) {
            if (_book.getId() == bookID) {
                book = _book;
                break;
            }
        }
        return book;
    }

    // add new book to list
    public Book addBook(Book book) {
        try {
            return this._bookRepository.save(book);
        } catch (Exception ex) {
            return null;
        }
    }

    // update existing book by it's id
    public Book updateBook(Book book) {
        try {
            Book _book = getBookById(book.getId());
            if (_book != null) {
                _book.setAuthor(book.getAuthor());
                _book.setTitle(book.getTitle());
                return this._bookRepository.save(_book);
            }
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    // delete book
    public boolean deleteBook(int bookID) {
        try {
            Book _book = getBookById(bookID);
            if (_book != null) {
                this._bookRepository.deleteById(bookID);
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }
}

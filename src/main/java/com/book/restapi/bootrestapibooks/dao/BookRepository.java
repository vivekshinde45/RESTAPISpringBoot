package com.book.restapi.bootrestapibooks.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.book.restapi.bootrestapibooks.entities.Book;

@Service
public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findById(int id);
}

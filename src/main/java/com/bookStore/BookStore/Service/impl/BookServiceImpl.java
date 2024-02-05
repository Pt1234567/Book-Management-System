package com.bookStore.BookStore.Service.impl;

import com.bookStore.BookStore.Entity.Book;
import com.bookStore.BookStore.Repository.BookRepository;
import com.bookStore.BookStore.Service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private  BookRepository bookRepository;
    public BookServiceImpl(BookRepository b){
        bookRepository=b;
    }

    @Override
    public void save(Book b) {
        bookRepository.save(b);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }
}

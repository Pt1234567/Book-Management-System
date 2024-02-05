package com.bookStore.BookStore.Service.impl;

import com.bookStore.BookStore.Entity.Book;
import com.bookStore.BookStore.Entity.MyBooksList;
import com.bookStore.BookStore.Repository.MyBookRepository;
import com.bookStore.BookStore.Service.MyBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookServiceImpl implements MyBookService {

    public MyBookServiceImpl(MyBookRepository myBookRepository) {
        this.myBookRepository = myBookRepository;
    }

    private MyBookRepository myBookRepository;

    @Override
    public void saveMyBooks(MyBooksList myBooksList) {
        myBookRepository.save(myBooksList);
    }

    @Override
    public List<MyBooksList> getAllMyBooks() {
        return myBookRepository.findAll();
    }

    @Override
    public void deleteMyBookById(Long id) {
        myBookRepository.deleteById(id);
    }
}

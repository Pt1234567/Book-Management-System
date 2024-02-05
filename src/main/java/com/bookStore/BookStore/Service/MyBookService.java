package com.bookStore.BookStore.Service;

import com.bookStore.BookStore.Entity.MyBooksList;

import java.util.List;

public interface MyBookService {

    public void saveMyBooks(MyBooksList myBooksList);
    List<MyBooksList> getAllMyBooks();

    public void deleteMyBookById(Long id);
}

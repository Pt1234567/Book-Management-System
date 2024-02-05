package com.bookStore.BookStore.Service;

import com.bookStore.BookStore.Entity.Book;

import java.util.List;

public interface BookService {

  public void save(Book b);
  List<Book> getAllBook();

}

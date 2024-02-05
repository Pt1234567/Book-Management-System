package com.bookStore.BookStore.Repository;

import com.bookStore.BookStore.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}

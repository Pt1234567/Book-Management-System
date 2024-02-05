package com.bookStore.BookStore.Repository;

import com.bookStore.BookStore.Entity.MyBooksList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyBookRepository extends JpaRepository<MyBooksList,Long> {
}

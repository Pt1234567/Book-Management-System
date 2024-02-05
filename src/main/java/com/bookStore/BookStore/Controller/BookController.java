package com.bookStore.BookStore.Controller;

import com.bookStore.BookStore.Entity.Book;
import com.bookStore.BookStore.Service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    private BookService bookService;
    public BookController(BookService bS){
        bookService=bS;
    }

    @GetMapping("/book")
    public String getBookStore(){
        return "bookStore";
    }

    @GetMapping("/book_register")
    public String bookRegister(Model model){
        Book b=new Book();

        model.addAttribute("book",b);

        return "bookRegister";
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        bookService.save(b);
        return "redirect:/book";
    }

    @GetMapping("/available_books")
    public String getListOfBooks(Model model){
        model.addAttribute("book",bookService.getAllBook());
        return "book_list";
    }
}

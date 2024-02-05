package com.bookStore.BookStore.Controller;

import com.bookStore.BookStore.Entity.Book;
import com.bookStore.BookStore.Entity.MyBooksList;
import com.bookStore.BookStore.Service.BookService;
import com.bookStore.BookStore.Service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    private MyBookService myBookService;
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

    @GetMapping("/my_books")
    public String goToMyBooks(Model model){
        List<MyBooksList> myBooksLists=myBookService.getAllMyBooks();
        model.addAttribute("mybook",myBooksLists);
        return "myBooks";
    }

    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable ("id") Long id){
        Book b=bookService.getBookById(id);
        MyBooksList myBook=new MyBooksList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookService.saveMyBooks(myBook);
        return "redirect:/my_books";
    }

    @RequestMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id,Model model){
        Book b=bookService.getBookById(id);
        model.addAttribute("edit",b);
        return "bookEdit";
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable Long id,@ModelAttribute("edit") Book book,Model model){
       Book existingBook=bookService.getBookById(id);
       existingBook.setId(book.getId());
       existingBook.setAuthor(book.getAuthor());
       existingBook.setName(book.getName());
       existingBook.setPrice(book.getPrice());

       bookService.save(existingBook);

        return "redirect:/available_books";
    }

    @GetMapping("/deleteFromAvailable/{id}")
    public String deleteAvailable(@PathVariable Long id){
        bookService.deleteBookById(id);
        return "redirect:/available_books";
    }
}

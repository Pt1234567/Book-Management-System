package com.bookStore.BookStore.Controller;

import com.bookStore.BookStore.Service.MyBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyBookController {
    public MyBookController(MyBookService myBookService) {
        this.myBookService = myBookService;
    }

    private MyBookService myBookService;

    @GetMapping("/deleteFromList/{id}")
    public String deleteById(@PathVariable("id") Long id){
        myBookService.deleteMyBookById(id);
        return"redirect:/my_books";
    }
}

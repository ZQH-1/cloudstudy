package com.test.controller;

import com.test.service.BookService;
import entity.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookController {
    @Resource
    private BookService bookService;

    @RequestMapping("/book/{bid}")
    public Book getBootById(@PathVariable("bid") int bid){
        Book book = bookService.getBookById(bid);
        return book;
    }
}

package com.test.service.Impl;

import com.test.mapper.BookMapper;
import com.test.service.BookService;
import entity.Book;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;

    @Override
    public Book getBookById(int bid) {
        Book book = bookMapper.getBookById(bid);
        return book;
    }
}

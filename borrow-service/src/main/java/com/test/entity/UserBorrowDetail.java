package com.test.entity;

import entity.Book;
import entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserBorrowDetail {
    User user;
    List<Book> bookList;
}

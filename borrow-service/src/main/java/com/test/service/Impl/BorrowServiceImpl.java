package com.test.service.Impl;

import com.test.entity.UserBorrowDetail;
import com.test.mapper.BorrowMapper;
import com.test.service.BorrowService;
import entity.Book;
import entity.Borrow;
import entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    private BorrowMapper borrowMapper;
    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid){
        List<Borrow> borrows=borrowMapper.getBorrowByUid(uid);

        RestTemplate restTemplate=new RestTemplate();
        User user = restTemplate.getForObject("http://localhost:8380/user/" + uid, User.class);

        List<Book> bookList = borrows.stream().map(b -> restTemplate.getForObject("http://localhost:8180/book/" + b.getBid(), Book.class)).collect(Collectors.toList());

        return new UserBorrowDetail(user,bookList);
    }


}

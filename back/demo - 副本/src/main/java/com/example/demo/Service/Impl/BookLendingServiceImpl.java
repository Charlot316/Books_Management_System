package com.example.demo.Service.Impl;

import com.example.demo.Dao.BookLendingDao;
import com.example.demo.Entity.BookLending;
import com.example.demo.Service.BookLendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLendingServiceImpl implements BookLendingService {

    @Autowired
    private BookLendingDao bookLendingDao;

    @Override
    public void insertBookLendingRecord(BookLending bookLending) {
        bookLendingDao.insertBookLendingRecord(bookLending);
    }
}

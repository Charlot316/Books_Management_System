package com.example.demo.Dao;

import com.example.demo.Entity.BookLending;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookLendingDao {
    public void insertBookLendingRecord(BookLending bookLending);
}

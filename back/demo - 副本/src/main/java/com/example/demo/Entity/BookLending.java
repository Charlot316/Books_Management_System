package com.example.demo.Entity;

import java.util.Date;


public class BookLending {
    private int userId;
    private int bookId;
    private Date lendDate;
    private Date dueDate;

    public BookLending(int userId, int bookId, Date lendDate, Date returnDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.lendDate = lendDate;
        this.dueDate = returnDate;
    }

    public int getUserId() {
        return userId;
    }

    public int getBookId() {
        return bookId;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public Date getReturnDate() {
        return dueDate;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public void setReturnDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}

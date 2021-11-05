package com.example.demo.Controller;

import com.example.demo.Entity.BookLending;
import com.example.demo.Service.BookLendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BookLendingController {
    @Autowired
    BookLendingService bookLendingService;
    @Autowired
    HttpServletRequest request;
    @PostMapping("/booklending")
    public Map<String, Object> bookLending(@RequestBody Map<String, Integer> remap) {
        Map<String, Object> map = new HashMap<>();
        // System.out.println(request.getSession().getAttribute("username"));
        Integer bookId = remap.get("bookId");
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        // System.out.println(userId + " " + bookId);
        map.put("success", true);
        map.put("message", "借书成功！");
        Date lendDate = new Date();
        Date dueDate = timeProcess(new Date());
        BookLending bookLending = new BookLending(userId, bookId, lendDate, dueDate);
        bookLendingService.insertBookLendingRecord(bookLending);
        return map;
    }
    public Date timeProcess(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, 1);
        Date dt1 = rightNow.getTime();
        return dt1;
    }
}


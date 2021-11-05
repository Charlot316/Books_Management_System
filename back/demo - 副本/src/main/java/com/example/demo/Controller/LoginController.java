package com.example.demo.Controller;

import com.example.demo.Entity.Student;
import com.example.demo.Entity.User;
import com.example.demo.Service.StudentService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(HttpServletRequest request, @RequestBody Map<String, String> remap) {
        String username = remap.get("username");
        String password = remap.get("password");
        Map<String, Object> map = new HashMap<>();
        try{
            User user1 = userService.selectUserByUsername(username);
            if (user1 == null) {
                map.put("success", true);
                map.put("message", "用户账号不存在！");
            } else if (user1.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                Integer userId = user1.getUserId();
                // System.out.println("-------------" + user1.getUserId());
                session.setAttribute("userId", userId);
                session.setAttribute("username",username);
                session.setAttribute("password",password);
                map.put("success", true);
                map.put("message", "用户登录成功！");
            } else {
                map.put("success", false);
                map.put("message", "密码错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "出现未知错误！");
        }

        return map;
    }
}

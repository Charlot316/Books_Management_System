package com.example.demo.Controller;

import com.example.demo.Entity.Student;
import com.example.demo.Entity.User;
import com.example.demo.Service.StudentService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Map<String, Object> registerNewUser(@RequestBody Map<String, String> remap) {
        String username = (String) remap.get("username");
        String password = (String) remap.get("password");
        Integer role = Integer.parseInt(remap.get("role"));
        String email = (String) remap.get("email");
        Integer sex =  Integer.parseInt(remap.get("sex"));
        Map<String, Object> map = new HashMap<>();
        try {
            User user = new User(username, password, role, email, sex);
            User user1 = userService.selectUserByUsername(user.getUsername());
            if (user1 != null) {
                map.put("success", false);
                map.put("message", "用户名已注册！");
            }
            else{
                userService.registerNewUser(user);
                map.put("success", true);
                map.put("message", "用户注册成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "用户注册失败！");
        }
        return map;
    }
}

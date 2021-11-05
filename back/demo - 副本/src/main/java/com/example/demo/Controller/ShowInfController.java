package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ShowInfController {
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/show_info")
    public Map<String, Object> showInf() {
        Map<String, Object> map = new HashMap<>();
        try {
            if (request.getSession().getAttribute("username") == null) {
                map.put("success" , false);
                map.put("message", "用户未登录");
            } else {
                String username = (String) request.getSession().getAttribute("username");
                String password = (String) request.getSession().getAttribute("password");
                map.put("password", password);
                map.put("name", username);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "出现未知错误！");
        }
        return map;
    }

}

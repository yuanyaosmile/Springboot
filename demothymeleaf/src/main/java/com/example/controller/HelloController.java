package com.example.controller;

import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class HelloController {
    @Autowired
    User user;

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/index")
    public String indexController(Model model) {
        user.setUsername("Barry");
        user.setPassword("Iris west");
        model.addAttribute("user", user);

        HttpSession session = request.getSession();
        session.setAttribute("hello", "world");
        return "index";
    }
}

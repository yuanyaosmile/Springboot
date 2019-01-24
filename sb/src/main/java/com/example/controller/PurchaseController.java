package com.example.controller;

import com.example.pojo.Result;
import com.example.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@RestController
@Controller
@RequestMapping("/product")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/purchase")
    //@ResponseBody
    public String purchase(Long userId, Long productId, Integer quantity) {
        boolean success = purchaseService.purchase(userId, productId, quantity);
        String msg = success ? "success" : "failed";
        Result result = new Result(success, msg);
        HttpSession session = request.getSession();
        session.setAttribute("result", result);
        return "index";
    }

    @RequestMapping("/get")
    public String get(){
        return  "index";
    }
}

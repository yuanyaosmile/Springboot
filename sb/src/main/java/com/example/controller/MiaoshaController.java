package com.example.controller;

import com.example.domain.MiaoshaOrder;
import com.example.domain.OrderInfo;
import com.example.pojo.SkUser;
import com.example.result.CodeMsg;
import com.example.service.GoodsService;
import com.example.service.MiaoshaService;
import com.example.service.OrderService;
import com.example.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoshaService miaoshaService;

    @RequestMapping("/do_miaosha")
    public String list(Model model, SkUser user, @RequestParam("goodsId") Long goodsId){
        model.addAttribute("user", user);

        if (user == null) {
            return "login";
        }
        //判断库存
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goods.getStock_count();

        if (stock <= 0){
            model.addAttribute("errmsg", CodeMsg.MIAOSHA_FAIL.getMsg());
            return  "miaosha_fail";
        }

        //判断是否已经秒杀到
        MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(), goodsId);
        if (order != null) {
            model.addAttribute("errmsg", CodeMsg.MIAOSHA_REPATE.getMsg());
            return "miaosha_fail";
        }

        //减库存
        OrderInfo orderInfo = miaoshaService.miaoshao(user, goods);

        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("goods", goods);
        return "order_detail";
    }
}

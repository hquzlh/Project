package com.zhuliheng.shoppingcart.controller;

import com.zhuliheng.shoppingcart.entities.Cart;
import com.zhuliheng.shoppingcart.entities.Goods;
import com.zhuliheng.shoppingcart.entities.Order;
import com.zhuliheng.shoppingcart.entities.User;
import com.zhuliheng.shoppingcart.entities.dto.GoodsNumDto;
import com.zhuliheng.shoppingcart.entities.dto.UserMoneyDto;
import com.zhuliheng.shoppingcart.entities.vo.OrderVo;
import com.zhuliheng.shoppingcart.service.CartService;
import com.zhuliheng.shoppingcart.service.GoodsService;
import com.zhuliheng.shoppingcart.service.OrderService;
import com.zhuliheng.shoppingcart.service.UserService;
import com.zhuliheng.shoppingcart.util.DateUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shopping-cart
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-09 14:36
 **/
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    OrderService orderService;
    @Autowired
    CartService cartService;
    @Autowired
    UserService userService;
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAllByUid(HttpSession session){
        User user= (User) session.getAttribute("user");
        Integer uid=user.getUid();
        List<Order> orderList=orderService.findOrderByUid(uid);
        List<OrderVo> orderVoList=new ArrayList<>();
        for (Order order: orderList) {
            Goods goods=goodsService.findByGid(order.getGid());
            orderVoList.add(new OrderVo(goods.getUri(),uid,order.getGid(),goods.getName()
                    ,goods.getPrice(),order.getNum(),order.getOrderNumber(),order.getDate()));
        }
        return JSONArray.fromObject(orderVoList).toString();
    }
    @RequestMapping("/insert")
    @ResponseBody
    public String insertOrder(@RequestParam(value="chk[]")int[] chk,HttpSession session){
        User user= (User) session.getAttribute("user");
        List<Order> orderList=new ArrayList<>();
        String date= DateUtil.getDate();
        Integer myMoney=userService.getMoney(user.getUid());
        Integer total=0;
        for (int i = 0; i <chk.length ; i++) {
            int orderNumber=1;
            Cart cart=cartService.findByUidAndGid(user.getUid(),chk[i]);
            Goods goods=goodsService.findByGid(chk[i]);
            if(cart.getNum()>goods.getNum()){

                return cart.getName()+"数量超过库存，当前库存为"+goods.getNum() +"请修改!!";
            }else {
                total+=cart.getNum()*cart.getPrice();
                if(orderService.findOrderNumber()!=null){
                    orderNumber=orderService.findOrderNumber()+1;
                }
                orderList.add(new Order(user.getUid(),chk[i],cart.getNum(),orderNumber,date));
            }
        }
        if(myMoney<total){
            return "false";
        }else {
            userService.updateMoney(new UserMoneyDto(user.getUid(),0-total));
        }
        for (Order order: orderList) {
            goodsService.updateStock(new GoodsNumDto(order.getGid(),0-order.getNum()));
            cartService.deleteCart(cartService.findByUidAndGid(user.getUid(),order.getGid()).getId());
            orderService.insert(order);
        }
        return "true";
    }
}

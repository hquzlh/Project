package com.zhuliheng.shoppingcart.controller;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.net.HttpResponse;

import com.zhuliheng.shoppingcart.entities.Cart;
import com.zhuliheng.shoppingcart.entities.Goods;
import com.zhuliheng.shoppingcart.entities.Tags;
import com.zhuliheng.shoppingcart.entities.User;
import com.zhuliheng.shoppingcart.entities.dto.CartNumDto;
import com.zhuliheng.shoppingcart.entities.dto.GoodsNumDto;
import com.zhuliheng.shoppingcart.entities.vo.GoodAndFile;
import com.zhuliheng.shoppingcart.service.CartService;
import com.zhuliheng.shoppingcart.service.GoodsService;
import com.zhuliheng.shoppingcart.util.CodeUtil;
import com.zhuliheng.shoppingcart.util.CookieUtil;
import com.zhuliheng.shoppingcart.util.JedisPoolUtil;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
/**
 * @program: shopping-cart
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-02 15:53
 **/
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;
    @Autowired
    GoodsService goodsService;
    JedisPool jedisPool= JedisPoolUtil.getJedisPoolInstance();
    @ResponseBody
    @RequestMapping("/findAll")
    public String findAllCart(HttpSession session,HttpServletRequest request,HttpServletResponse response){

        User user = (User) session.getAttribute("user");
        List<Cart> carts=null;
        List<Cart> cartList=null;
        //默认购物车无
        Boolean tag=true;
        //登录了
        if(user!=null) {
            carts=cartService.findAllCart(user.getUid());;
            //String c = CookieUtil.getCookie(request,"cartList");
            //获取redis连接
            Jedis jedis=jedisPool.getResource();
            String c=CodeUtil.decode(jedis.get("cartList"));
            if(c!=null ){
                cartList= JSON.parseArray(c,Cart.class);
                if(cartList!=null) {
                    for (Cart cart : cartList) {
                        cart.setUid(user.getUid());
                        for (Cart cart1 : carts) {
                            if(cart1.getGid().equals(cart.getGid())){
                                tag=true;
                            }
                        }if(tag){
                            cartService.insertCart(cart);

                        }else {
                            for (int i = 0; i < cart.getNum(); i++) {
                                cartService.insertCart(cart);
                            }

                        }
                    }
                    cartList=null;
                    jedis.set("cartList", CodeUtil.encode(cartList));
                    JedisPoolUtil.release(jedis);
                    //CookieUtil.addCookie(response, cartList);
                }
            }
            carts = cartService.findAllCart(user.getUid());
        }else {
            Jedis jedis=jedisPool.getResource();
            String c=CodeUtil.decode(jedis.get("cartList"));
            JedisPoolUtil.release(jedis);
            //String c = CookieUtil.getCookie(request, "cartList");
            if(c!=null){
                carts= JSON.parseArray(c,Cart.class);

            }
        }
        return JSONArray.fromObject(carts).toString();

    }
    @ResponseBody
    @RequestMapping("/insert")
    public String insertCart(HttpSession session, Integer gid, HttpServletRequest request, HttpServletResponse response){
        User user= (User) session.getAttribute("user");
        Goods goods=goodsService.findByGid(gid);


        //String c = CookieUtil.getCookie(request, "cartList");
        List<Cart> cartList=null;
        //判断库存是否充足
        if(goodsService.judgeNum(gid))
        {
            //goodsService.updateStock(new GoodsNumDto(gid,goods.getNum()-1));
            if(user==null){
                //获取redis连接
                Jedis jedis=jedisPool.getResource();
                String c=CodeUtil.decode(jedis.get("cartList"));
                if(c!=null){
                    cartList=JSON.parseArray(c,Cart.class);
                }
                if(cartList!=null){
                    for(Cart cart:cartList){
                        if(cart.getGid().equals(gid)){
                            cart.setNum(cart.getNum()+1);
                            jedis.set("cartList", CodeUtil.encode(cartList));
                            JedisPoolUtil.release(jedis);
                            //CookieUtil.addCookie(response,cartList);
                            return "true";
                        }
                    }
                    List<Tags> tagsList=null;
                    String tags=goodsService.findTagByGid(gid);
                    Cart cart=new Cart(goods.getGid(),goods.getName(),1,goods.getPrice(),tags);
                    cartList.add(cart);

                    //CookieUtil.addCookie(response,cartList);
                }else {
                    cartList=new ArrayList<>();
                    List<Tags> tagsList=null;
                    String tags=goodsService.findTagByGid(gid);

                    Cart cart=new Cart(goods.getGid(),goods.getName(),1,goods.getPrice(),tags);
                    cartList.add(cart);
                    //CookieUtil.addCookie(response,cartList);
                }
                jedis.set("cartList", CodeUtil.encode(cartList));
                JedisPoolUtil.release(jedis);

            }else {//登录了
                List<Tags> tagsList=null;

                String tags=goodsService.findTagByGid(gid);

                Cart cart=new Cart(user.getUid(),goods.getGid(),goods.getName(),1,goods.getPrice(),tags);
                cartService.insertCart(cart);
            }
            //判断是否还有库存，true=有
            return "true";
        }else {

            return "false";
        }
    }
    @ResponseBody
    @RequestMapping("/delete")
    public String deleteCart(CartNumDto cartNumDto, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        User user= (User) session.getAttribute("user");
        Integer id=cartNumDto.getId();
        Integer gid=cartNumDto.getGid();
        Goods goods=goodsService.findByGid(gid);

        //String c = CookieUtil.getCookie(request, "cartList");
        List<Cart> cartList=null;
        int index=0;
        if(user==null){
            //获取redis连接
            Jedis jedis=jedisPool.getResource();
            String c=CodeUtil.decode(jedis.get("cartList"));
                cartList=JSON.parseArray(c,Cart.class);
            for(Cart cart:cartList){
                if(gid.equals(cart.getGid())){
                    //cartList.remove(cart);
                    index=cartList.indexOf(cart);
                    //goodsService.updateStock(new GoodsNumDto(gid,cart.getNum()+goods.getNum()));
                    //CookieUtil.addCookie(response,cartList);

                }
            }
            cartList.remove(index);
            jedis.set("cartList", CodeUtil.encode(cartList));
            JedisPoolUtil.release(jedis);
            return "true";
        }//登录了
        Cart cart=cartService.findById(id);
       // goodsService.updateStock(new GoodsNumDto(gid,cart.getNum()+goods.getNum()));
        cartService.deleteCart(id);
        return "true";
    }
    @ResponseBody
    @RequestMapping("/upCart")//id
    public String upCart(CartNumDto cartNumDto, HttpSession session, HttpServletRequest request,HttpServletResponse response){

        User user= (User) session.getAttribute("user");
        Integer id=cartNumDto.getId();
        Integer gid=cartNumDto.getGid();


        Cart cart=cartService.findById(id);
        Goods goods=goodsService.findByGid(cartNumDto.getGid());
        //String c = CookieUtil.getCookie(request, "cartList");

        //判断库存是否充足
        if(goodsService.judgeNum(cartNumDto.getGid())){
            //goodsService.updateStock(new GoodsNumDto(gid,goods.getNum()-1));
            if(user==null){
                //获取redis连接
                Jedis jedis=jedisPool.getResource();
                String c=CodeUtil.decode(jedis.get("cartList"));
                List<Cart> cartList=JSON.parseArray(c,Cart.class);
                    for(Cart cart1:cartList){
                        if(gid.equals(cart1.getGid())){
                            cart1.setNum(cart1.getNum()+1);
                            jedis.set("cartList", CodeUtil.encode(cartList));
                            JedisPoolUtil.release(jedis);
                            //CookieUtil.addCookie(response,cartList);

                            return "true";
                        }
                    }
            }else {//登录了
                cartService.upNum(id);

            }
        }else {
            return "false";
        }
        return "true";
    }
    @ResponseBody
    @RequestMapping("/downCart")
    public String downCart(CartNumDto cartNumDto,HttpServletRequest request,HttpServletResponse response,HttpSession session){
        User user= (User) session.getAttribute("user");
        Integer id=cartNumDto.getId();
        Integer gid=cartNumDto.getGid();
        Cart cart=cartService.findById(id);
        Goods goods=goodsService.findByGid(gid);

       // String c=CookieUtil.getCookie(request,"cartList");
        //goodsService.updateStock(new GoodsNumDto(gid, goods.getNum() + 1));
        if(user==null){
            //获取redis连接
            Jedis jedis=jedisPool.getResource();
            String c=CodeUtil.decode(jedis.get("cartList"));
            List<Cart> cartList=JSON.parseArray(c,Cart.class);
            for(Cart cart1:cartList){
                if(gid.equals(cart1.getGid())){
                    cart1.setNum(cart1.getNum()-1);
                    if(cart1.getNum()==0){
                        cartList.remove(cart1);
                    }
                    //CookieUtil.addCookie(response,cartList);
                    jedis.set("cartList", CodeUtil.encode(cartList));
                    JedisPoolUtil.release(jedis);
                    return "true";
                }
            }
        }//登录了
        if(cart.getNum()>1) {
            cartService.downNum(id);
        }else {
           cartService.deleteCart(id);
            return  "false";
        }
        return  "true";
    }

    @RequestMapping("/addMore")
    public String addMore(GoodsNumDto goodsNumDto,HttpSession session,HttpServletRequest request,HttpServletResponse response){
        Goods goods=goodsService.findByGid(goodsNumDto.getGid());
        User user= (User) session.getAttribute("user");

        //String c=CookieUtil.getCookie(request,"cartList");
        List<Cart> cartList=null;
            if(goodsNumDto.getNum()<=goods.getNum()){
                //goodsService.updateStock(new GoodsNumDto(goodsNumDto.getGid(),goods.getNum()-goodsNumDto.getNum()));
                if(user==null){
                    //获取redis连接
                    Jedis jedis=jedisPool.getResource();
                    String c=CodeUtil.decode(jedis.get("cartList"));
                    if(c!=null){
                       cartList=JSON.parseArray(c,Cart.class);
                    }
                    if(cartList!=null){
                        for(Cart cart:cartList){
                            if(cart.getGid().equals(goodsNumDto.getGid())){
                                for (int i = goodsNumDto.getNum(); i>0 ; i--) {
                                    cart.setNum(cart.getNum()+1);
                                }
                                jedis.set("cartList", CodeUtil.encode(cartList));
                                JedisPoolUtil.release(jedis);
                                //CookieUtil.addCookie(response,cartList);
                                return "redirect:/main.html";
                            }
                        }
                        List<Tags> tagsList=null;
                        String tags=goodsService.findTagByGid(goodsNumDto.getGid());

                        Cart cart=new Cart(null,goods.getGid(),goods.getName(),goodsNumDto.getNum(),goods.getPrice(),tags);
                        cartList.add(cart);
                        jedis.set("cartList", CodeUtil.encode(cartList));
                        JedisPoolUtil.release(jedis);
                        //CookieUtil.addCookie(response,cartList);
                        return "redirect:/main.html";
                    }else {
                        cartList=new ArrayList<>();
                        List<Tags> tagsList=null;
                        String tags=goodsService.findTagByGid(goodsNumDto.getGid());

                        Cart cart=new Cart(null,goods.getGid(),goods.getName(),goodsNumDto.getNum(),goods.getPrice(),tags);
                        cartList.add(cart);
                        jedis.set("cartList", CodeUtil.encode(cartList));
                        JedisPoolUtil.release(jedis);
                        //CookieUtil.addCookie(response,cartList);
                    }
                }else {//登录
                    List<Tags> tagsList=null;
                    String tags=goodsService.findTagByGid(goodsNumDto.getGid());

                    Cart cart1=new Cart(user.getUid(),goodsNumDto.getGid(),goods.getName(),1,goods.getPrice(),tags);
                    for (int i = goodsNumDto.getNum(); i>0 ; i--) {
                        cartService.insertCart(cart1);
                    }
                }
            }
        return "redirect:/main.html";
    }
    @ResponseBody
    @RequestMapping("/checkNum")
    public String checkNum(GoodsNumDto goodsNumDto){
        Goods goods=goodsService.findByGid(goodsNumDto.getGid());
        if(goods.getNum()>=goodsNumDto.getNum()){
            return "true";
        }else {
            return "false";
        }
    }
    @ResponseBody
    @RequestMapping("/deleteAll-1")
    public String deleteAll1(Integer uid){
        /*List<Cart> cartList=cartService.findAllCart(uid);
        for (Cart cart:cartList) {
            Goods goods=goodsService.findByGid(cart.getGid());
            goodsService.updateStock(new GoodsNumDto(cart.getGid(),cart.getNum()+goods.getNum()));
        }*/
        cartService.deleteAllCart(uid);
        return "true";
    }
    @ResponseBody
    @RequestMapping("/deleteAll-2")
    public String deleteAll2(HttpServletResponse response,HttpServletRequest request){
        List<Cart> cartList=null;
        /*String c = CookieUtil.getCookie(request, "cartList");
        cartList=JSON.parseArray(c,Cart.class);
        for (Cart cart:cartList) {
            Goods goods=goodsService.findByGid(cart.getGid());
            goodsService.updateStock(new GoodsNumDto(cart.getGid(),cart.getNum()+goods.getNum()));
            cartList.remove(cart);
        }*/
        //清空cookie中的购物车list
        //CookieUtil.addCookie(response,cartList);
        return "true";
    }
}

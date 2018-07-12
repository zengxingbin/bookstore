package com.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.Book;
import com.domain.Order;
import com.domain.OrderItem2;
import com.domain.Orderitem;
import com.domain.Orders;
import com.domain.User;
import com.exception.OrderException;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    private static final long serialVersionUID = 5675656935984242455L;
    
    @RequestMapping("createOrder")
    public String createOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //创建订单对象
        Order order = new Order();
        //获取表单数据封装到订单中
        try {
            BeanUtils.populate(order, request.getParameterMap());
            //生成订单号
            order.setId(UUID.randomUUID().toString());
            //从session中取出user,放到订单中
            order.setUser((User)request.getSession().getAttribute("loginUser"));
            //创建订单项列表
            List<OrderItem2> orderItems = new ArrayList<OrderItem2>();
            HttpSession session = request.getSession();
            //从session中取出购物车
            Map<Book,Integer> cart = (Map<Book, Integer>)session.getAttribute("cart");
            
            //遍历购物车
            for(Book p : cart.keySet()) {
                //创建订单项
                OrderItem2 oi = new OrderItem2();
                oi.setOrder(order);//订单
                oi.setBook(p);//商品
                oi.setBuynum(cart.get(p));//商品数量
                //将订单项加入到订单列表中
                orderItems.add(oi);
            }
            //将所有的订单项加入到订单中,到此为止生成一个订单
            order.setOrderItems(orderItems);
            //调用方法
            try {
                orderService.createOrder(order);
            } catch (OrderException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            request.setAttribute("order", order);
            //跳转到支付页面
            //request.getRequestDispatcher("/pay.jsp").forward(request, response);
            
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "forward:/page/pay.do";
    
    }
    @RequestMapping("findOrders.do")
    public String orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        try {
            List<Order> orders = orderService.findOrdersByUserId(loginUser.getId());
            request.setAttribute("orders", orders);
            //request.getRequestDispatcher("/orderlist.jsp").forward(request, response);
        } catch (OrderException e) {
            e.printStackTrace();
        }
        return "forward:/page/orderList.do";
        
    }
    @RequestMapping("findOrderInformation")
    public String orderInformation(HttpServletRequest request, HttpServletResponse response) {
        String orderId = request.getParameter("orderId");
        if(orderId != null) {
            try {
                Order order = orderService.findOrderByOrderId(orderId);
                if(order != null) {
                    request.setAttribute("order", order);
                    //request.getRequestDispatcher("/orderInfo.jsp").forward(request, response);
                } else { // 订单已失效
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "forward:/page/orderInfo.do";
    }
    @RequestMapping("pay")
    public String payOrder(HttpServletRequest request, HttpServletResponse response) {
        String orderId = request.getParameter("orderId");
        if(orderId != null) {
            try {
                Order order = orderService.findOrderByOrderId(orderId);
                if(order != null) {
                    request.setAttribute("order", order);
                    //request.getRequestDispatcher("/orderInfo.jsp").forward(request, response);
                } else { // 订单已失效
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "forward:/page/pay.do";
    }
    @RequestMapping("deleteOrder")
    public void deleteOrder(HttpServletRequest request, HttpServletResponse response) {
        String orderId = request.getParameter("orderId");
        if(orderId != null) {
            try {
                orderService.deleteOrder(orderId);
            } catch (OrderException e) {
                e.printStackTrace();
            }
        }
    }
}
    

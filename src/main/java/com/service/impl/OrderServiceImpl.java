package com.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookMapper;
import com.dao.OrderitemMapper;
import com.dao.OrdersMapper;
import com.domain.Book;
import com.domain.Order;
import com.domain.OrderItem2;
import com.domain.Orders;
import com.exception.OrderException;
import com.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersMapper orderMapper;
    @Autowired
    private OrderitemMapper orderItemMapper;
    @Autowired
    private BookMapper bookMapper;

    public void createOrder(Order order) throws OrderException {
        try {
            orderMapper.addOder(order);
            List<OrderItem2> orderItems = order.getOrderItems();
            for (int i = 0; i < orderItems.size(); i++) {
                OrderItem2 orderItem = orderItems.get(i);
                orderItemMapper.addOrderItem(orderItem);
            }
            for (int i = 0; i < orderItems.size(); i++) {
                OrderItem2 orderItem = orderItems.get(i);
                bookMapper.updateBook(orderItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> findOrdersByUserId(int id) throws OrderException {

        try {
            return orderMapper.findOrdersByUserId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderException("订单查看失败");
        }
        
       
    }

    

    public void deleteOrder(String orderId) throws OrderException {
     // 获取订单中的图书及数量
        try {
            List<OrderItem2> orderItemList = orderMapper.findorderItemsByOrderId(orderId);
            Map<String, Integer> bookMap = new HashMap<String, Integer>();
            for (OrderItem2 orderItem : orderItemList) {
                bookMapper.updateBook2(orderItem);
            }
            orderItemMapper.deleteOrderItem(orderId);
            orderMapper.deleteOrder(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderException("删除订单失败！");
        }

    }

    public void modifyOrderPaystate(String orderId, int paystate) throws OrderException {
        // TODO Auto-generated method stub

    }

    public Order findOrderByOrderId(String orderId) throws OrderException {
        Order order = null;
        try {
            OrderItem2 orderitem = new OrderItem2();
            orderitem.setOrder_id(orderId);
            order = orderMapper.findOrderByOrderId(orderId);
            order.setOrderItems(new ArrayList<OrderItem2>());
            List<OrderItem2> orderItemList = orderMapper.findorderItemsByOrderId(orderId);
            for (OrderItem2 orderItem : orderItemList) {
                orderItem.setOrder(order);
                orderItem.setBuynum(orderItem.getBuynum());
                Book book = bookMapper.queryBook(orderItem.getBook_isbn());//bookDao.queryBook((String) map.get("book_isbn"));
                orderItem.setBook(book);
                order.getOrderItems().add(orderItem);
            }
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderException("订单详情查看失败");
        }
    }

}

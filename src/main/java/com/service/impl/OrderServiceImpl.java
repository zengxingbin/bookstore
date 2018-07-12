package com.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookMapper;
import com.dao.OrderitemMapper;
import com.dao.OrdersMapper;
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

    public void createOrder(Order order) throws OrderException{
        try {
            orderMapper.addOder(order);
            List<OrderItem2> orderItems = order.getOrderItems();
            for(int i = 0; i< orderItems.size(); i++) {
                OrderItem2 orderItem = orderItems.get(i);
                orderItemMapper.addOrderItem(orderItem);
            }
            for(int i = 0; i < orderItems.size(); i++) {
                OrderItem2 orderItem = orderItems.get(i);
                bookMapper.updateBook(orderItem);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Orders> findOrdersByUserId(int id) throws OrderException {
        // TODO Auto-generated method stub
        return null;
    }

    public Orders findOrderByOrderId(String orderId) throws OrderException {
        // TODO Auto-generated method stub
        return null;
    }

    public void deleteOrder(String orderId) throws OrderException {
        // TODO Auto-generated method stub

    }

    public void modifyOrderPaystate(String orderId, int paystate) throws OrderException {
        // TODO Auto-generated method stub

    }

}

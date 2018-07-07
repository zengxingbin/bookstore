package com.service.impl;

import com.dao.BookMapper;
import com.dao.OrderitemMapper;
import com.dao.OrdersMapper;
import com.domain.Book;
import com.domain.Orderitem;
import com.domain.Orders;
import com.exception.OrderException;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrdersMapper orderDao;

    @Autowired
    OrderitemMapper orderItemDao;

    @Autowired
    BookMapper bookDao;

    public void addOrder(Orders order) throws OrderException {
        try {
            orderDao.addOder(order);
            orderItemDao.addOrderItems(order.getOrderItems());
            bookDao.updateBooks001(order.getOrderItems());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderException("订单生成失败！");
        }
    }

    public List<Orders> findOrdersByUserId(int id) throws OrderException {
        try {
            return orderDao.findOrdersByUserId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderException("订单查看失败");
        }
    }

    public Orders findOrderByOrderId(String orderId) throws OrderException {
        Orders order = null;
        try {
            order = orderDao.findOrderByOrderId(orderId);
            order.setOrderItems(new ArrayList<Orderitem>());
            List<Map<String, Object>> orderItemList = orderItemDao.findorderItemDaosByOrderId(orderId);
            for (Map<String, Object> map : orderItemList) {
                Orderitem orderItem = new Orderitem();
                orderItem.setOrders(order);
                orderItem.setOrderId(order.getId());
                orderItem.setBuynum((Integer) map.get("buynum"));
                Book book = bookDao.queryBook((String) map.get("book_isbn"));
                orderItem.setBook(book);
                orderItem.setBookIsbn(book.getIsbn());
                order.getOrderItems().add(orderItem);
            }
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderException("订单详情查看失败");
        }
    }

    public void deleteOrder(String orderId) throws OrderException {
        // 获取订单中的图书及数量
        try {
            List<Map<String, Object>> orderItemList = orderItemDao.findorderItemDaosByOrderId(orderId);
            Map<String, Integer> bookMap = new HashMap<String, Integer>();
            for (Map<String, Object> map : orderItemList) {
                bookMap.put((String) map.get("book_isbn"), (Integer) map.get("buynum"));
            }
            bookDao.updateBooks002(bookMap);
            orderItemDao.deleteOrderItem(orderId);
            orderDao.deleteOrder(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderException("删除订单失败！");
        }
    }

    public void modifyOrderPaystate(String orderId, int paystate) throws OrderException {
        try {
            orderDao.modifyOrderPaystate(orderId, paystate);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderException("修改订单支付状态失败！");
        }
    }
}

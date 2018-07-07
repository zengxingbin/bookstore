package com.service;

import com.domain.Orders;
import com.exception.OrderException;

import java.util.List;

public interface OrderService {
    /**
     * 向数据库添加订单
     * @param order
     * @throws OrderException
     */
    void addOrder(Orders order) throws OrderException;

    /**
     * 查找用户订单
     * @param id
     * @return
     * @throws OrderException
     */
    List<Orders> findOrdersByUserId(int id) throws OrderException;

    /**
     * 根据订单ID查找订单
     * @param orderId
     * @return
     * @throws OrderException
     */
    Orders findOrderByOrderId(String orderId) throws OrderException;

    /**
     * 删除订单
     * @param orderId
     * @throws OrderException
     */
    void deleteOrder(String orderId) throws OrderException;

    /**
     *
     * @param orderId
     * @param paystate
     * @throws OrderException
     */
    void modifyOrderPaystate(String orderId, int paystate) throws OrderException;
}

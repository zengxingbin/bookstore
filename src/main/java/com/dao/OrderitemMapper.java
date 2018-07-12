package com.dao;

import com.domain.Order;
import com.domain.OrderItem2;
import com.domain.Orderitem;
import com.domain.OrderitemExample;
import com.domain.OrderitemKey;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrderitemMapper {
    int countByExample(OrderitemExample example);

    int deleteByExample(OrderitemExample example);

    int deleteByPrimaryKey(OrderitemKey key);

    int insert(Orderitem record);

    int insertSelective(Orderitem record);

    List<Orderitem> selectByExample(OrderitemExample example);

    Orderitem selectByPrimaryKey(OrderitemKey key);

    int updateByExampleSelective(@Param("record") Orderitem record, @Param("example") OrderitemExample example);

    int updateByExample(@Param("record") Orderitem record, @Param("example") OrderitemExample example);

    int updateByPrimaryKeySelective(Orderitem record);

    int updateByPrimaryKey(Orderitem record);

    /**
     * 添加的订单项
     * @param orderItem
     * @throws SQLException
     */
    void addOrderItem(OrderItem2 orderItem) throws SQLException;

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    List<Map<String, Object>> findorderItemDaosByOrderId(String id) throws SQLException;

    /**
     *
     * @param orderId
     * @throws SQLException
     */
    void deleteOrderItem(String orderId) throws SQLException;


}
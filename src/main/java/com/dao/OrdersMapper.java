
package com.dao;

import com.domain.Orders;
import com.domain.OrdersExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersMapper {
    int countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    /**
     * 添加订单
     * @param order
     * @throws SQLException
     */
    void addOder(Orders order) throws SQLException;

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    List<Orders> findOrdersByUserId(int id) throws SQLException;

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    Orders findOrderByOrderId(String id) throws SQLException;

    /**
     *
     * @param orderId
     * @throws SQLException
     */
    void deleteOrder(String orderId) throws SQLException;

    /**
     *
     * @param orderId
     * @param paystate
     * @throws SQLException
     */
    void modifyOrderPaystate(@Param("orderId")String orderId, @Param("paystate")int paystate) throws SQLException;
}
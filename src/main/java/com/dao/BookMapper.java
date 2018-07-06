package com.dao;

import com.domain.Book;
import com.domain.BookExample;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.domain.Orderitem;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {
    int countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(String isbn);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(String isbn);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    /**
     * 获取一本图书
     * @param isbn
     * @return
     * @throws SQLException
     */
    public Book queryBook(String isbn) throws SQLException;

    /**
     * 获取所有的图书列表
     * @return
     * @throws SQLException
     */
    public List<Book> queryBooks() throws SQLException;

    /**
     * 查询图书
     * @param isbn
     * @param name
     * @param category
     * @param minPrice
     * @param maxPrice
     * @return
     * @throws SQLException
     */
    public List<Book> queryBooks001(@Param("isbn")String isbn, @Param("name")String name, @Param("category")String category,
                                 @Param("minPrice")String minPrice, @Param("maxPrice")String maxPrice) throws SQLException;

    /**
     * 分页查询
     * @param beginIndex
     * @param resultNumber
     * @return
     * @throws SQLException
     */
    public List<Book> queryBooks002(@Param("beginIndex")int beginIndex, @Param("resultNumber")int resultNumber) throws SQLException;

    /**
     *
     * @param isbn
     * @param name
     * @param category
     * @param minPrice
     * @param maxPrice
     * @param beginIndex
     * @param resultNumber
     * @return
     * @throws SQLException
     */
    public List<Book> queryBooks003(@Param("isbn")String isbn, @Param("name")String name, @Param("category")String category,
                                 @Param("minPrice")String minPrice, @Param("maxPrice")String maxPrice, @Param("beginIndex")int beginIndex, @Param("resultNumber")int resultNumber) throws SQLException;

    /**
     * 添加一本图书
     * @param newBook
     * @return
     * @throws SQLException
     */
    public void insertBook(Book newBook) throws SQLException;

    /**
     * 删除图书
     * @param isbn
     * @return
     * @throws SQLException
     */
    public void deleteBook(String isbn) throws SQLException;

    /**
     * 更新图书信息
     * @param newBook
     * @return
     * @throws SQLException
     */
    public void updateBook(Book newBook) throws SQLException;

    /**
     *
     * updateBook(List<OrderItem> orderItems)
     * @param orderItems
     * @throws SQLException
     */
    public void updateBooks001(List<Orderitem> orderItems) throws SQLException;

    /**
     *
     * updateBook(Map<String, Integer> bookMap) t
     * @param bookMap
     * @throws SQLException
     */
    public void updateBooks002(Map<String, Integer> bookMap) throws SQLException;

    /**
     * 批量删除图书
     * @param isbns
     * @return
     * @throws SQLException
     */
    public void deleteBooks(String[] isbns) throws SQLException;

    /**
     * 获取图书总数
     * @return
     * @throws SQLException
     */
    public int count() throws SQLException;

    /**
     * count(String isbn, String name, String category,String minPrice, String maxPrice)
     * 获取图书总数
     * @param isbn
     * @param name
     * @param category
     * @param minPrice
     * @param maxPrice
     * @return
     * @throws SQLException
     */
    public int count001(@Param("isbn")String isbn, @Param("name")String name, @Param("category")String category,
                     @Param("minPrice")String minPrice, @Param("maxPrice")String maxPrice) throws SQLException;


}
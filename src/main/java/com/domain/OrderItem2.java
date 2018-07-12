package com.domain;

public class OrderItem2 {
    private Order order;    // 订单
    private Book book;      // 商品
    private int buynum;     // 购物数量
    private String order_id;
    private String book_isbn;
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public int getBuynum() {
        return buynum;
    }
    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }
    public String getOrder_id() {
        return order_id;
    }
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
    public String getBook_isbn() {
        return book_isbn;
    }
    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }
    
}

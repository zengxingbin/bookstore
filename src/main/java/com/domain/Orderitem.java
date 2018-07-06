package com.domain;

public class Orderitem extends OrderitemKey {

    private Integer buynum;

    private String bookIsbn;

    private String orderId;

    public Integer getBuynum() {
        return buynum;
    }

    public void setBuynum(Integer buynum) {
        this.buynum = buynum;
    }

    @Override
    public String getBookIsbn() {
        return bookIsbn;
    }

    @Override
    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    @Override
    public String getOrderId() {
        return orderId;
    }

    @Override
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
package com.domain;

public class Book {
    private String isbn;

    private String name;

    private Double price;

    private Integer pnum;

    private String category;

    private String description;

    private String bookcoverpath;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPnum() {
        return pnum;
    }

    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getBookcoverpath() {
        return bookcoverpath;
    }

    public void setBookcoverpath(String bookcoverpath) {
        this.bookcoverpath = bookcoverpath == null ? null : bookcoverpath.trim();
    }
}
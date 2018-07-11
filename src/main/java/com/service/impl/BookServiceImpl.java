package com.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookMapper;
import com.domain.Book;
import com.domain.Page;
import com.domain.QueryCondition;
import com.exception.BookException;
import com.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    public Book getBook(String isbn) throws BookException {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Book> getBooks() throws BookException {
        // TODO Auto-generated method stub
        return null;
    }

    public void getBooksByPage(Page page) throws BookException {
        int bookNumber = 0;
        if (page.getSearchName() != null) {
            try {
                bookNumber = bookMapper.countByName(page.getSearchName());
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else
            bookNumber = bookMapper.countAll();
        page.setBookNumber(bookNumber);
        int resultNumber = page.getPageSize();
        page.setPageNumber((int) (Math.ceil(bookNumber * 1.0 / resultNumber)));
        int beginIndex = (page.getCurrentPage() - 1) * resultNumber;
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.setName(page.getSearchName());
        queryCondition.setBeginIndex(beginIndex);
        queryCondition.setResultNumber(resultNumber);
        List<Book> books;
        try {
            books = bookMapper.queryBooksLimit(queryCondition);

            page.setBooks(books);
            page.setCurrentPageSize(books.size());
            page.setRowNumber((int) (Math.ceil(books.size() * 1.0 / page.getColumnNumber())));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void getBooksBySearchName(String searchName, Page page) throws BookException {
        // 获取图书的总数
        try {
            int bookNumber = bookMapper.countByName(searchName);
            page.setBookNumber(bookNumber);
            int resultNumber = page.getPageSize();
            page.setPageNumber((int) (Math.ceil(bookNumber * 1.0 / resultNumber)));
            int beginIndex = (page.getCurrentPage() - 1) * resultNumber;
            QueryCondition queryCondition = new QueryCondition();
            queryCondition.setName(searchName);
            queryCondition.setBeginIndex(beginIndex);
            queryCondition.setResultNumber(resultNumber);
            List<Book> books = bookMapper.queryBooksLimit(queryCondition);
            page.setBooks(books);
            page.setCurrentPageSize(books.size());
            page.setRowNumber((int) (Math.ceil(books.size() * 1.0 / page.getColumnNumber())));

        } catch (SQLException e) {
            e.printStackTrace();
            throw new BookException("分页查询失败！");
        }

    }

    public List<Book> queryBooks(String isbn, String name, String category, String minPrice, String maxPrice)
            throws BookException {
        return null;
    }

    public List<Book> queryBooks(String name) throws BookException {
        List<Book> bookList = bookMapper.queryBookByName(name);
        return bookList;
    }

    public void queryBooks(String isbn, String name, String category, String minPrice, String maxPrice, Page page)
            throws BookException {
        // TODO Auto-generated method stub

    }

    public void queryBooks(QueryCondition queryCondition, Page page) throws BookException {
        // TODO Auto-generated method stub

    }

    public void addBook(Book newBook) throws BookException {
        // TODO Auto-generated method stub

    }

    public Book modifyBook(Book newBook) throws BookException {
        // TODO Auto-generated method stub
        return null;
    }

    public Book deleteBook(String isbn) throws BookException {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Book> deleteBooks(String[] isbns) {
        // TODO Auto-generated method stub
        return null;
    }

    public void getBooksByCategory(String category, Page page) throws BookException {
        int bookNumber = bookMapper.countByCategory(category);
        page.setBookNumber(bookNumber);
        int resultNumber = page.getPageSize();
        page.setPageNumber((int) (Math.ceil(bookNumber * 1.0 / resultNumber)));
        int beginIndex = (page.getCurrentPage() - 1) * resultNumber;
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.setCategory(category);
        queryCondition.setBeginIndex(beginIndex);
        queryCondition.setResultNumber(resultNumber);
        List<Book> books = null;
        try {
            books = bookMapper.queryBooksLimit(queryCondition);
            page.setBooks(books);
            page.setCurrentPageSize(books.size());
            page.setRowNumber((int) (Math.ceil(books.size() * 1.0 / page.getColumnNumber())));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new BookException("分页查询失败！");
        }
    }

}

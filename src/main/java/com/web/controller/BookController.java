package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.Book;
import com.domain.Page;
import com.exception.BookException;
import com.service.BookService;

import net.sf.json.JSONArray;


@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("searchBookName")
    public void searchBookName(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String searchName = request.getParameter("searchname");

        String echo = request.getParameter("echo");
        if(echo != null && "true".equals(echo)) {
            List<Book> books = null;
            try {
                books = bookService.queryBooks(searchName);
            } catch (BookException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                return;
            }
            
            Set<String> bookNameSet = new LinkedHashSet<String>();
            for (Book book : books) {
                bookNameSet.add(book.getName());
            }
            String bookNameList = JSONArray.fromObject(bookNameSet).toString();
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            out.print(bookNameList);
            out.flush();
            out.close();
        }
        else {
            HttpSession session = request.getSession();
            Page page = (Page) session.getAttribute("page");
            if(page == null) {
                page = new Page(8, 4);
            }
            page.setCategory("全部图书");
            page.setSearchName(searchName);
            
            try {
                bookService.getBooksBySearchName(searchName, page);
            } catch (BookException e) {
                e.printStackTrace();
            }
            
            session.setAttribute("page", page);
            String path = "/product_list.jsp";
            //request.getRequestDispatcher(path).forward(request, response);
        }
    }
    
    @RequestMapping("searchBookByName")
    public String seachBookByName(String searchname,HttpSession session) {
        Page page = (Page) session.getAttribute("page");
        if(page == null) {
            page = new Page(8, 4);
        }
        page.setCategory("全部图书");
        page.setSearchName(searchname);
        page.setCurrentPage(1);
        try {
            bookService.getBooksBySearchName(searchname, page);
        } catch (BookException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        session.setAttribute("page", page);
        return "forward:/page/product_list.do";
    }
    @RequestMapping("searchBookByCategory")
    public String searchBookByCategory(String category,HttpSession session) {
        Page page = (Page) session.getAttribute("page");
        if(page == null) {
            page = new Page(8, 4);
        }
        page.setCategory(category);
        page.setCurrentPage(1);
        page.setSearchName(null);
        try {
            if("全部图书".equals(category )) {
                bookService.getBooksByPage(page);   
            } else {
                bookService.getBooksByCategory(category, page);
            }
        }catch(BookException e) {
            e.printStackTrace();
        }
        
        session.setAttribute("page", page);
        return "forward:/page/product_list.do";
    }
    @RequestMapping("changePage")
    public String changePage(HttpServletRequest request,HttpSession session) {
        Page page = (Page) session.getAttribute("page");
        if(page == null) {
            page = new Page(8, 4);
            page.setCategory("全部图书");
        }
        int currentPage = page.getCurrentPage();
        if(request.getParameter("previouspage") != null) {
            if(currentPage > 1) {
                currentPage--;
            }
        } else {
            if(currentPage < page.getPageNumber()) {
                currentPage++;
            }
        }
        page.setCurrentPage(currentPage);
        if(request.getParameter("currentPage") != null) {
            page.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
        }
        String category = page.getCategory();
        try {
            if("全部图书".equals(category )) {
                bookService.getBooksByPage(page);   
            } else {
                bookService.getBooksByCategory(category, page);
            }
        }catch(BookException e) {
            e.printStackTrace();
        }
        
        session.setAttribute("page", page);
        return "forward:/page/product_list.do"; 
    }
}

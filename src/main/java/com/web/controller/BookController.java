package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.BookMapper;
import com.domain.Book;
import com.domain.Page;
import com.domain.User;
import com.exception.BookException;
import com.service.BookService;
import com.service.impl.BookServiceImpl;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("searchBookName")
    public void searchBookName(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String searchName = request.getParameter("searchname");

        String echo = request.getParameter("echo");
        if (echo != null && "true".equals(echo)) {
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
        } else {
            HttpSession session = request.getSession();
            Page page = (Page) session.getAttribute("page");
            if (page == null) {
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
            // request.getRequestDispatcher(path).forward(request, response);
        }
    }

    @RequestMapping("searchBookByName")
    public String seachBookByName(String searchname, HttpSession session) {
        Page page = (Page) session.getAttribute("page");
        if (page == null) {
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
    public String searchBookByCategory(String category, HttpSession session) {
        Page page = (Page) session.getAttribute("page");
        if (page == null) {
            page = new Page(8, 4);
        }
        page.setCategory(category);
        page.setCurrentPage(1);
        page.setSearchName(null);
        try {
            if ("全部图书".equals(category)) {
                bookService.getBooksByPage(page);
            } else {
                bookService.getBooksByCategory(category, page);
            }
        } catch (BookException e) {
            e.printStackTrace();
        }

        session.setAttribute("page", page);
        return "forward:/page/product_list.do";
    }

    @RequestMapping("changePage")
    public String changePage(HttpServletRequest request, HttpSession session) {
        Page page = (Page) session.getAttribute("page");
        if (page == null) {
            page = new Page(8, 4);
            page.setCategory("全部图书");
        }
        int currentPage = page.getCurrentPage();
        if (request.getParameter("previouspage") != null) {
            if (currentPage > 1) {
                currentPage--;
            }
        } else {
            if (currentPage < page.getPageNumber()) {
                currentPage++;
            }
        }
        page.setCurrentPage(currentPage);
        if (request.getParameter("currentPage") != null) {
            page.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
        }
        String category = page.getCategory();
        try {
            if ("全部图书".equals(category)) {
                bookService.getBooksByPage(page);
            } else {
                bookService.getBooksByCategory(category, page);
            }
        } catch (BookException e) {
            e.printStackTrace();
        }

        session.setAttribute("page", page);
        return "forward:/page/product_list.do";
    }

    @RequestMapping("showBookInformation")
    public String showBookInformation(String isbn, Model model) {
        Book book = null;
        try {
            book = bookService.getBook(isbn);
            model.addAttribute("book", book);
        } catch (BookException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "forward:/page/product_info.do";
    }

    @RequestMapping("addCart")
    public String addCart(String isbn, HttpSession session) {
        Book book = new Book();
        book.setIsbn(isbn);
        User user = (User) session.getAttribute("loginUser");
       
        Map<Book, Integer> cart =  (Map<Book, Integer>) session.getAttribute("cart");
        
        try {
            doAddCart(session, cart, book);
        } catch (BookException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "redirect:/page/cart.do";
    }

    @RequestMapping("changeCart")
    public void changeCart(HttpServletRequest request, PrintWriter writer) {
        String numberChangeStr = request.getParameter("numberChange");
        
        String isbn = request.getParameter("isbn");     
        Book book = new Book();
        book.setIsbn(isbn);
        
        HttpSession session = request.getSession();
        Map<Book, Integer> cart = (Map<Book, Integer>) session.getAttribute("cart");        
        int numberChange = Integer.parseInt(numberChangeStr);
        doChangeCart(cart, book, numberChange);
        Set<Book> bookSet = cart.keySet();
        float subtotal = 0.0f;
        float total = 0.0f;
        int number = 0;
        for (Book key : bookSet) {
            int value = cart.get(key);
            total += value * key.getPrice();
            if(book.equals(key)) {
                number = value;
                subtotal = (float) (key.getPrice() * value);
            }
        }           
        String jsonObj = "{'number':" + number + ", 'subtotal':" + subtotal + ", 'total':" + total + " }"; 
        writer.write(jsonObj);
        writer.flush();
        writer.close();
    }
    @RequestMapping("deleteCart")
    public void deleteCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String isbn = request.getParameter("isbn");
        Book book = new Book();
        book.setIsbn(isbn);
        Map<Book, Integer> cart = (Map<Book, Integer>) request.getSession().getAttribute("cart");
        if(cart.containsKey(book)) {
            cart.remove(book);
            Set<Entry<Book,Integer>> entrySet = cart.entrySet();
            float total = 0.0f;
            for (Entry<Book, Integer> entry : entrySet) {
                total += entry.getValue() * entry.getKey().getPrice();
            }
            PrintWriter writer = response.getWriter();
            writer.write(total + "");
            writer.flush();
            writer.close();
            return;
            
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
    }
    private void doAddCart(HttpSession session, Map<Book, Integer> cart, Book book) throws BookException {
        if (cart == null) {
            cart = new LinkedHashMap<Book, Integer>();
            session.setAttribute("cart", cart);
        } else {
            if (cart.containsKey(book)) {
                int number = cart.get(book);
                cart.put(book, ++number);
                return;
            }
        }

        book = bookService.getBook(book.getIsbn());
        cart.put(book, 1);
    }
    private void doChangeCart(Map<Book, Integer> cart, Book book, int numberChange) {
        if(cart != null) {
            if(cart.containsKey(book)) {
                Set<Entry<Book,Integer>> entrySet = cart.entrySet();
                for (Entry<Book, Integer> entry : entrySet) {
                    if(book.equals(entry.getKey())) {
                        if(numberChange == 1) {
                            if(entry.getValue() == entry.getKey().getPnum())
                                return;                         
                        } else {
                            if(entry.getValue() == 1)
                                return;
                        }
                    }
                }
                cart.put(book, cart.get(book) + numberChange);
            }
        }       
    }

}

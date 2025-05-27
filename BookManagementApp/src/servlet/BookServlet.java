package servlet;

import dao.BookDAO;
import model.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class BookServlet extends HttpServlet {
    BookDAO dao = new BookDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Book> books = dao.getAllBooks();
            request.setAttribute("books", books);
            RequestDispatcher rd = request.getRequestDispatcher("booklist.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            double price = Double.parseDouble(request.getParameter("price"));

            Book book = new Book();
            book.setTitle(title);
            book.setAuthor(author);
            book.setPrice(price);
            dao.insertBook(book);

            response.sendRedirect("books");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

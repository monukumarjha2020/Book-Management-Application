package dao;

import java.sql.*;
import java.util.*;
import model.Book;

public class BookDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/bookdb";
	private static final String USER = "root";  // your DB username
	private static final String PASS = "";  // your DB password


    public List<Book> getAllBooks() throws SQLException {
        List<Book> list = new ArrayList<>();
        Connection conn = DriverManager.getConnection(URL, USER, PASS);
        String sql = "SELECT * FROM books";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Book b = new Book();
            b.setId(rs.getInt("id"));
            b.setTitle(rs.getString("title"));
            b.setAuthor(rs.getString("author"));
            b.setPrice(rs.getDouble("price"));
            list.add(b);
        }
        return list;
    }

    public void insertBook(Book book) throws SQLException {
        String sql = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
        Connection conn = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setDouble(3, book.getPrice());
        ps.executeUpdate();
    }

    public void deleteBook(int id) throws SQLException {
        String sql = "DELETE FROM books WHERE id=?";
        Connection conn = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
